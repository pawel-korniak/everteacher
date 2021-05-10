package com.epam.jap.everteacher.syllabus;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("course")
@RequiredArgsConstructor
class CourseController {
    private final CourseService courseService;

    @GetMapping("all")
    List<Course> showAll() {
        return courseService.showAll();
    }

//    @EventListener(ApplicationReadyEvent.class)
//    void save() {
//        courseService.save(CourseProvider.getProvider().provide());
//    }

}
