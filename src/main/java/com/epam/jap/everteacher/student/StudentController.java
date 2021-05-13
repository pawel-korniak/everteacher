package com.epam.jap.everteacher.student;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
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
    ResponseEntity<Student> findById(@PathVariable Long studentId) {
        return new ResponseEntity<>(studentService.findById(studentId), HttpStatus.OK);
    }

    @PostMapping("{studentId}/finish/{topicId}")
    ResponseEntity<Student> markTopicAsFinished(@PathVariable Long studentId, @PathVariable Long topicId) {
        return new ResponseEntity<>(studentService.markTopicAsFinished(studentId, topicId), HttpStatus.OK);
    }

    @PostMapping("{studentId}/block/{topicId}")
    ResponseEntity<Student> markTopicAsBlocked(@PathVariable Long studentId, @PathVariable Long topicId) {
        return new ResponseEntity<>(studentService.markTopicAsBlocked(studentId, topicId),HttpStatus.OK);
    }

    @PostMapping("{studentId}/unblock/{topicId}")
    ResponseEntity<Student> unblockTopic(@PathVariable Long studentId, @PathVariable Long topicId) {
        return new ResponseEntity<>(studentService.unblockTopic(studentId, topicId),HttpStatus.OK);
    }


//    @EventListener(ApplicationReadyEvent.class)
//    void save() {
//        studentService.saveAll(List.of(
//                new Student("Nika", "Veronika"),
//                new Student("Pawel", "Pawelko"),
//                new Student("Pawel", "Prokop"),
//                new Student("Lukasz", "Zaba"),
//                new Student("Magdalena", "Kwiecinska"),
//                new Student("Paulina", "Ogorzalek")
//        ));
//    }
}
