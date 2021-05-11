package com.epam.jap.everteacher.student;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
class StudentController {
    private final StudentService studentService;

    @PostMapping
    Student add(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping()
    List<Student> showAll() {
        return studentService.showAll();
    }

    @GetMapping("{studentId}")
    Student getStudentById(@PathVariable Long studentId) {
        return studentService.findById(studentId);
    }

    @PostMapping("{studentId}/finish/{topicId}")
    Student markTopicAsFinished(@PathVariable Long studentId, @PathVariable Long topicId) {
        return studentService.markTopicAsFinished(studentId, topicId);
    }


    @EventListener(ApplicationReadyEvent.class)
    void save() {
        studentService.saveAll(List.of(
                new Student("Nika", "Veronika"),
                new Student("Pawel", "Pawelko"),
                new Student("Pawel", "Prokop"),
                new Student("Lukasz", "Zaba"),
                new Student("Magdalena", "Kwiecinska"),
                new Student("Paulina", "Ogorzalek")
        ));
    }
}
