package com.epam.jap.everteacher.syllabus;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("course")
@RequiredArgsConstructor
public class CourseController {
    final CourseService courseService;

    @GetMapping
    public List<Course> showAll() {
        return courseService.showAll();
    }

    @EventListener(ApplicationReadyEvent.class)
    void save() {
        courseService.save(new CourseFromFile().provide());
    }

}
