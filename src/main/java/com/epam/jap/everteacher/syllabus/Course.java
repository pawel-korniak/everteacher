package com.epam.jap.everteacher.syllabus;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Entity
@NoArgsConstructor
public class Course {
    @GeneratedValue
    @Id
    Long id;
    String name;
    @Column(name = "start_date")
    LocalDate startDate;
    @Column(name = "end_date")
    LocalDate endDate;
    @Column(name = "super_topics")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<SuperTopic> superTopics;

    public Course(String name, LocalDate startDate, LocalDate endDate, List<SuperTopic> superTopics) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.superTopics = superTopics;
    }

    public List<Topic> allTopics() {

        return superTopics.stream()
                .map(SuperTopic::getTopicList)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}

