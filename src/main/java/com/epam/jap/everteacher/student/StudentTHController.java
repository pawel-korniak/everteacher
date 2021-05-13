package com.epam.jap.everteacher.student;

import lombok.RequiredArgsConstructor;
import org.pmw.tinylog.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;

@RequiredArgsConstructor
@Controller
public class StudentTHController {

    final StudentService studentService;

    @GetMapping("{studentId}")
    String showAll(Model model,@PathVariable Long studentId) {
        final Student student = studentService.findById(studentId);
        var superTopics = student.getCourse().getSuperTopics();


        Logger.info("Student : " + student);
        model.addAttribute("student", student);
        Logger.info("Course : " + student.getCourse());
        model.addAttribute("course", student.getCourse());
//        model.addAttribute("topics", student.getCourse().allTopics());
        Logger.info("Supertopics : " + superTopics);
        model.addAttribute("superTopics", superTopics);
        return "index";
    }


    @PostMapping
    ResponseEntity<Student> save(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }

//    @GetMapping
//    ResponseEntity<List<Student>> showAll() {
//        return new ResponseEntity<>(studentService.showAll(), HttpStatus.OK);
//    }

//    @GetMapping("{studentId}")
//    ResponseEntity<Student> findById(@PathVariable Long studentId) {
//        return new ResponseEntity<>(studentService.findById(studentId), HttpStatus.OK);
//    }

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
}
