package com.epam.jap.everteacher.student;

import com.epam.jap.everteacher.teacher.Teacher;
import lombok.RequiredArgsConstructor;
import org.pmw.tinylog.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@RequiredArgsConstructor
@Controller
@RequestMapping("students")
public class StudentTHController {

    final StudentService studentService;

    @GetMapping
    String start(@AuthenticationPrincipal UserDetails user){
        if(user instanceof Student) {
            Student student = (Student) user;
            Logger.info(String.format("Logged student : name %s , ID %d REDIRECTING to %s",student.getUsername(),student.getId(),"redirect:/students/" + student.getId()));
            return "redirect:/students/" + student.getId();
        }
        Logger.info("Logged teacher");
        return "redirect:/students/19";
    }

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

    @PostMapping("{studentId}/finish/{topicId}")
    String  markTopicAsFinished(@PathVariable Long studentId, @PathVariable Long topicId) {
        studentService.markTopicAsFinished(studentId, topicId);
        return "redirect:/students/" + studentId;
    }

    @PostMapping("{studentId}/unfinish/{topicId}")
    String  markTopicAsUnfinished(@PathVariable Long studentId, @PathVariable Long topicId) {
        studentService.markTopicAsUnfinished(studentId, topicId);
        return "redirect:/students/" + studentId;
    }

    @PostMapping("{studentId}/block/{topicId}")
    String markTopicAsBlocked(@PathVariable Long studentId, @PathVariable Long topicId) {
        studentService.markTopicAsBlocked(studentId, topicId);
        return "redirect:/students/" + studentId;
    }

    @PostMapping("{studentId}/unblock/{topicId}")
    String unblockTopic(@PathVariable Long studentId, @PathVariable Long topicId) {
        studentService.unblockTopic(studentId, topicId);
        return "redirect:/students/" + studentId;
    }


//    @GetMapping
//    ResponseEntity<List<Student>> showAll() {
//        return new ResponseEntity<>(studentService.showAll(), HttpStatus.OK);
//    }

//    @GetMapping("{studentId}")
//    ResponseEntity<Student> findById(@PathVariable Long studentId) {
//        return new ResponseEntity<>(studentService.findById(studentId), HttpStatus.OK);
//    }



//
//
//
}
