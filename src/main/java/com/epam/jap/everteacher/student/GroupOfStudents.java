package com.epam.jap.everteacher.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "student_group")
public class GroupOfStudents {
    @Id
    @GeneratedValue
    Long id;
    String name;
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Student> students;

    public GroupOfStudents(String groupName) {
        name = groupName;
    }
}
