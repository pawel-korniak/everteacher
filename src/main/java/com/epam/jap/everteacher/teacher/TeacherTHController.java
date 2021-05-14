package com.epam.jap.everteacher.teacher;

import com.epam.jap.everteacher.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller
@RequestMapping
@RequiredArgsConstructor
public class TeacherTHController {

    private final StudentService studentService;

    @GetMapping("list")
    String start(Model model,@AuthenticationPrincipal UserDetails user){
        model.addAttribute("list",studentService.showAll());
        model.addAttribute("principal",user.getUsername());
        return "students";
    }
}
