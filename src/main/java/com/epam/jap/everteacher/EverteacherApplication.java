package com.epam.jap.everteacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.epam.jap.everteacher")
public class EverteacherApplication {

    public static void main(String[] args) {
        SpringApplication.run(EverteacherApplication.class, args);
    }

}
