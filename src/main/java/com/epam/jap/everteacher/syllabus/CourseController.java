package com.epam.jap.everteacher.syllabus;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/courses")
@RequiredArgsConstructor
class CourseController {
    private final CourseService courseService;

    @GetMapping
    ResponseEntity<List<Course>> showAll() {
        List<Course> courses = courseService.showAll();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
