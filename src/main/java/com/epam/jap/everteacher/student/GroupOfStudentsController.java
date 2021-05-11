package com.epam.jap.everteacher.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("groups")
@RequiredArgsConstructor
public class GroupOfStudentsController {
    private final GroupOfStudentsService groupOfStudentsService;
    private final StudentService studentService;

    @PostMapping("add")
    GroupOfStudents addGroup(@RequestBody GroupOfStudents groupOfStudents) {
//        Group group = new Group(groupName);
        return groupOfStudentsService.save(groupOfStudents);
    }

    @PostMapping("{groupId}")
    GroupOfStudents addStudentsToGroup(@PathVariable Long groupId, @RequestParam List<Long> id) {
        List<Student> studentList = studentService.findAllById(id);
        return groupOfStudentsService.addStudents(groupId,studentList);
    }
}
