package com.epam.jap.everteacher.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupOfStudentsService {
    private final GroupOfStudentsRepository groupOfStudentsRepository;

    public GroupOfStudents addStudents(Long groupId, List<Student> studentList) {
        GroupOfStudents groupOfStudents = groupOfStudentsRepository.findById(groupId).orElseThrow();
        groupOfStudents.setStudents(studentList);
        return groupOfStudentsRepository.save(groupOfStudents);
    }

    public GroupOfStudents save(GroupOfStudents groupOfStudents) {
        return groupOfStudentsRepository.save(groupOfStudents);
    }
}
