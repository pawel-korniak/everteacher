package com.epam.jap.everteacher.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;
    private final StudentService studentService;

    @PostMapping("add")
    StudentGroup addGroup(@RequestBody StudentGroup studentGroup) {
//        Group group = new Group(groupName);
        return groupService.save(studentGroup);
    }

    @PostMapping("{groupId}")
    StudentGroup addStudentsToGroup(@PathVariable Long groupId, @RequestParam List<Long> id) {
        List<Student> studentList = studentService.findAllById(id);
        return groupService.addStudents(groupId,studentList);
    }
}
