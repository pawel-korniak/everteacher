package com.epam.jap.everteacher.student;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {
    final StudentService studentService;

    @PostMapping("save")
    public Student add(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping("finish/{id}")
    public Student markTopicAsFinished(@RequestParam Long topicId, @PathVariable Long id) {
        return studentService.markTopicAsFinished(topicId, id);
    }

    @EventListener(ApplicationReadyEvent.class)
    void save() {
        studentService.saveAll(List.of(new Student("Nika", "Veronika"),
                new Student("Pawel", "Pawelko")));
    }


}
