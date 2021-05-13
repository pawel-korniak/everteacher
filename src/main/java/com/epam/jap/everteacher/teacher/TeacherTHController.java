package com.epam.jap.everteacher.teacher;

import com.epam.jap.everteacher.student.StudentService;
import lombok.RequiredArgsConstructor;
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
    String start(Model model){
        model.addAttribute("list",studentService.showAll());
        return "students";
    }
}
