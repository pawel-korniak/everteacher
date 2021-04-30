package com.epam.jap.everteacher;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public String hello(){
        return "Hello Dear Guest";
    }

    @GetMapping("hello")
    public String privateHello(@AuthenticationPrincipal User user){
        return "Hello Dear Student : " + user.getUsername();
    }

    @GetMapping("hi")
    public String privateHi(@AuthenticationPrincipal User user){
        return "Hello Dear Teacher " + user.getUsername();
    }
}
