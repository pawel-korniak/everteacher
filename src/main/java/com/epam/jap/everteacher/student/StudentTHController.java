package com.epam.jap.everteacher.student;

import com.epam.jap.everteacher.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.pmw.tinylog.Logger;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("students")
public class StudentTHController {

    final StudentService studentService;

    @GetMapping
    String start(@AuthenticationPrincipal UserDetails user) {
        if (user instanceof Student) {
            Student student = (Student) user;
            Logger.info(String.format("Logged student : name %s , ID %d REDIRECTING to %s", student.getUsername(), student.getId(), "redirect:/students/" + student.getId()));
            return "redirect:/students/" + student.getId();
        }
        Logger.info("Logged teacher");
        return "redirect:/list";
    }

    @GetMapping("{studentId}")
    String findById(Model model, @PathVariable Long studentId, @AuthenticationPrincipal UserDetails user) throws UserNotFoundException {
        if (user instanceof Student) {
            var loggedStudentId = ((Student) user).getId();
            if (!loggedStudentId.equals(studentId)) {
                throw new org.springframework.security.access.AccessDeniedException("403 returned");
            }
        }
        Student student = studentService.findById(studentId);

        var superTopics = student.getCourse().getSuperTopics();
        Logger.info("Student : " + student);
        model.addAttribute("student", student);
        Logger.info("Course : " + student.getCourse());
        model.addAttribute("course", student.getCourse());
        Logger.info("Supertopics : " + superTopics);
        model.addAttribute("superTopics", superTopics);
        Logger.info("User : " + user.getUsername());
        model.addAttribute("principal", user.getUsername());
        return "index";
    }

    @PostMapping("{studentId}/finish/{topicId}")
    String markTopicAsFinished(@PathVariable Long studentId, @PathVariable Long topicId) {
        studentService.markTopicAsFinished(studentId, topicId);
        return "redirect:/students/" + studentId;
    }

    @PostMapping("{studentId}/unfinish/{topicId}")
    String markTopicAsUnfinished(@PathVariable Long studentId, @PathVariable Long topicId) {
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
}
