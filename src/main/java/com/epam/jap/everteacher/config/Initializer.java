package com.epam.jap.everteacher.config;

import com.epam.jap.everteacher.teacher.Teacher;
import com.epam.jap.everteacher.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class Initializer {
    private final TeacherService teacherService;

    @EventListener(ApplicationReadyEvent.class)
    void save() {
        teacherService.saveAll(List.of(new Teacher("Tomek", "Borek"),
                new Teacher("Marcin", "Borek")));
    }
}
