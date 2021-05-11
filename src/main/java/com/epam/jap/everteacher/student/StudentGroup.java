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
public class StudentGroup {
    @Id
    @GeneratedValue
    Long id;
    String name;
    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "students_group",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id",
                    referencedColumnName = "id"))
    List<Student> students;

    public StudentGroup(String groupName) {
        name = groupName;
    }
}
