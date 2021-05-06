package com.epam.jap.everteacher.syllabus;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Entity
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
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "supertopic_course",
            joinColumns = @JoinColumn(name = "supertopic_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id",
                    referencedColumnName = "id"))
    List<SuperTopic> superTopics;

    public Course(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public List<Topic> allTopics() {

        return superTopics.stream()
                .map(SuperTopic::getTopicList)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}

