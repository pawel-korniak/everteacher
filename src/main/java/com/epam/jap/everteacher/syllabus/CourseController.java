package com.epam.jap.everteacher.syllabus;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping
    ResponseEntity<Course> saveCourse(@RequestParam("course")MultipartFile multipartFile){
        Course course = null;
        try {
            course = courseService.saveCourseFromFile(new String(multipartFile.getBytes()), multipartFile.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(course,HttpStatus.CREATED);
    }
}
