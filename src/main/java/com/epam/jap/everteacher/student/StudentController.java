package com.epam.jap.everteacher.student;

import com.epam.jap.everteacher.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.pmw.tinylog.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor
class StudentController {
    private final StudentService studentService;

    @PostMapping
    ResponseEntity<Student> save(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Student>> showAll() {
        return new ResponseEntity<>(studentService.showAll(), HttpStatus.OK);
    }

    @GetMapping("{studentId}")
    ResponseEntity<Student> findById(@PathVariable Long studentId) throws UserNotFoundException {

        Logger.error("Hello from api/students, You are looking for student with id: " + studentId);
        Student student = studentService.findById(studentId);


        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("{studentId}/finish/{topicId}")
    ResponseEntity<Student> markTopicAsFinished(@PathVariable Long studentId, @PathVariable Long topicId) {
        return new ResponseEntity<>(studentService.markTopicAsFinished(studentId, topicId), HttpStatus.OK);
    }

    @PostMapping("{studentId}/unfinish/{topicId}")
    ResponseEntity<Student> markTopicAsUnFinished(@PathVariable Long studentId, @PathVariable Long topicId) {
        return new ResponseEntity<>(studentService.markTopicAsUnfinished(studentId, topicId), HttpStatus.OK);
    }

    @PostMapping("{studentId}/block/{topicId}")
    ResponseEntity<Student> markTopicAsBlocked(@PathVariable Long studentId, @PathVariable Long topicId) {
        return new ResponseEntity<>(studentService.markTopicAsBlocked(studentId, topicId), HttpStatus.OK);
    }

    @PostMapping("{studentId}/unblock/{topicId}")
    ResponseEntity<Student> unblockTopic(@PathVariable Long studentId, @PathVariable Long topicId) {
        return new ResponseEntity<>(studentService.unblockTopic(studentId, topicId), HttpStatus.OK);
    }

}
