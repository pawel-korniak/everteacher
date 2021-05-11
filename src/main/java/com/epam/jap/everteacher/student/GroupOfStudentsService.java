package com.epam.jap.everteacher.student;

import com.epam.jap.everteacher.syllabus.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupOfStudentsService {
    private final GroupOfStudentsRepository groupOfStudentsRepository;

    public GroupOfStudents addStudentsToGroup(Long groupId, List<Student> studentList) {
        GroupOfStudents groupOfStudents = groupOfStudentsRepository.findById(groupId).orElseThrow();
        groupOfStudents.setStudents(studentList);
        return groupOfStudentsRepository.save(groupOfStudents);
    }

    public GroupOfStudents save(GroupOfStudents groupOfStudents) {
        return groupOfStudentsRepository.save(groupOfStudents);
    }

    public GroupOfStudents findById(Long groupId) {
        return groupOfStudentsRepository.findById(groupId).orElseThrow();
    }

    public GroupOfStudents signStudentsToCourse(GroupOfStudents groupOfStudents, Course course) {
        groupOfStudents.getStudents().forEach(student -> student.setCourse(course));
        return groupOfStudentsRepository.save(groupOfStudents);
    }
}
