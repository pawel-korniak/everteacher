package com.epam.jap.everteacher;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {

    @GetMapping("add")
    public String sendText(@RequestParam String text){
        return text;
    }

    @GetMapping
    public String hello(){
        return "Hello Dear Guest";
    }

    @GetMapping("hello")
    public String privateHello(@AuthenticationPrincipal User student){
        return "Hello Dear Student : " + student.getUsername();
    }

    @GetMapping("hi")
    public String privateHi(@AuthenticationPrincipal User teacher){
        return "Hello Dear Teacher " + teacher.getUsername();
    }



}
