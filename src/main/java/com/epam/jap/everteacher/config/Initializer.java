package com.epam.jap.everteacher.config;

import com.epam.jap.everteacher.student.Student;
import com.epam.jap.everteacher.student.StudentService;
import com.epam.jap.everteacher.syllabus.CourseProvider;
import com.epam.jap.everteacher.syllabus.CourseService;
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
//    private final StudentService studentService;
//    private final CourseService courseService;
//    private final TeacherService teacherService;
//
//    @EventListener(ApplicationReadyEvent.class)
//    void save() {
//        studentService.saveAll(List.of(
//                new Student("Nika", "Veronika"),
//                new Student("Pawel", "Pawelko"),
//                new Student("Pawel", "Prokop"),
//                new Student("Lukasz", "Zaba"),
//                new Student("Magdalena", "Kwiecinska"),
//                new Student("Paulina", "Ogorzalek")
//        ));
//        courseService.save(CourseProvider.getProvider().provide());
//        teacherService.saveAll(List.of(new Teacher("Tomek", "Borek"),
//                new Teacher("Marcin", "Borek")));
//    }
}
