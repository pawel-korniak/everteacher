package com.epam.jap.everteacher.syllabus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "topic")
public class Topic {
    @GeneratedValue
    @Id
    Long id;
    String name;
    LocalDate deadline;

//    @ManyToMany(mappedBy = "topics",fetch = FetchType.LAZY)
//    List<Student> students;

    public Topic(String name, LocalDate deadline) {
        this.name = name;
        this.deadline = deadline;
    }
}
