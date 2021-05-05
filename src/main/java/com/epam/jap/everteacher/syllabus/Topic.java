package com.epam.jap.everteacher.syllabus;

import com.epam.jap.everteacher.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
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
