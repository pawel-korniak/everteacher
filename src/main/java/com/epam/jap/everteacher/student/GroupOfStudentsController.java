package com.epam.jap.everteacher.student;

import com.epam.jap.everteacher.syllabus.Course;
import com.epam.jap.everteacher.syllabus.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/groups")
@RequiredArgsConstructor
public class GroupOfStudentsController {
    private final GroupOfStudentsService groupOfStudentsService;
    private final StudentService studentService;
    private final CourseService courseService;

    @GetMapping("{groupId}")
    ResponseEntity<GroupOfStudents> findById(@PathVariable Long groupId) {
        return new ResponseEntity<>(groupOfStudentsService.findById(groupId), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<GroupOfStudents> save(@RequestParam("group") MultipartFile multipartFile) {
        byte[] multipartFileBytes = new byte[0];
        try {
            multipartFileBytes = multipartFile.getBytes();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return new ResponseEntity<>(groupOfStudentsService.saveStudentsFromFile(new String(multipartFileBytes),
                multipartFile.getOriginalFilename()), HttpStatus.CREATED);
    }

    @PostMapping("add-group-with-course")
    ResponseEntity<GroupOfStudents> saveGroupWithCourse(@RequestParam("group") MultipartFile multipartFileGroup,
                                                        @RequestParam("course") MultipartFile multipartFileCourse) {
        byte[] groupFileBytes = new byte[0];
        byte[] courseFileBytes = new byte[0];

        try {
            groupFileBytes = multipartFileGroup.getBytes();
            courseFileBytes = multipartFileCourse.getBytes();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        GroupOfStudents groupOfStudents = groupOfStudentsService.saveStudentsFromFile(new String(groupFileBytes),
                multipartFileGroup.getOriginalFilename());
        Course course = courseService.saveCourseFromFile(new String(courseFileBytes));

        return new ResponseEntity<>(groupOfStudentsService.signStudentsToCourse(groupOfStudents, course), HttpStatus.I_AM_A_TEAPOT);
    }

    @PostMapping("{groupId}")
    ResponseEntity<GroupOfStudents> addStudentsToGroup(@PathVariable Long groupId, @RequestParam List<Long> id) {
        List<Student> studentList = studentService.findAllById(id);
        return new ResponseEntity<>(groupOfStudentsService.addStudentsToGroup(groupId, studentList), HttpStatus.OK);
    }

    @PostMapping("{groupId}/sign-to-course/{courseId}")
    ResponseEntity<GroupOfStudents> signStudentsToCourse(@PathVariable Long groupId, @PathVariable Long courseId) {
        Course course = courseService.findById(courseId);
        GroupOfStudents groupOfStudents = groupOfStudentsService.findById(groupId);
        return new ResponseEntity<>(groupOfStudentsService.signStudentsToCourse(groupOfStudents, course), HttpStatus.OK);
    }

}
