package com.epam.jap.everteacher.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public StudentGroup addStudents(Long groupId, List<Student> studentList) {
        StudentGroup studentGroup = groupRepository.findById(groupId).orElseThrow();
        studentGroup.setStudents(studentList);
        return groupRepository.save(studentGroup);
    }

    public StudentGroup save(StudentGroup studentGroup) {
        return groupRepository.save(studentGroup);
    }
}
