package com.epam.jap.everteacher.teacher;

import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("teacher")
public class TeacherController {

    final TeacherService teacherService;

    @GetMapping("add")
    public String sendText(@RequestParam String text){
        return text;
    }

    @PostMapping("save")
    public Teacher saveTeacher(@RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping()
    public List<Teacher> showAll() {
        return teacherService.findAllTeachers();
    }

//    @GetMapping("hello")
//    public String privateHello(@AuthenticationPrincipal User student){
//        return "Hello Dear Student : " + student.getUsername();
//    }
//
//    @GetMapping("hi")
//    public String privateHi(@AuthenticationPrincipal User teacher){
//        return "Hello Dear Teacher " + teacher.getUsername();
//    }



}
