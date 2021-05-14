package com.epam.jap.everteacher;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class EverTeacherApplication {

    public static void main(String[] args) {
        SpringApplication.run(EverTeacherApplication.class, args);
    }

}
