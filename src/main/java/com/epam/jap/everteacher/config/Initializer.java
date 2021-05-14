package com.epam.jap.everteacher.config;

import com.epam.jap.everteacher.student.Student;
import com.epam.jap.everteacher.student.StudentService;
import com.epam.jap.everteacher.syllabus.Course;
import com.epam.jap.everteacher.syllabus.CourseProvider;
import com.epam.jap.everteacher.syllabus.CourseService;
import com.epam.jap.everteacher.teacher.Teacher;
import com.epam.jap.everteacher.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.pmw.tinylog.Logger;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class Initializer {
    private final StudentService studentService;
    private final CourseService courseService;
    private final TeacherService teacherService;

//    @EventListener(ApplicationReadyEvent.class)
//    void save() {
//        Course course = CourseProvider.getProvider().provide();
//        courseService.save(course);
//        studentService.saveAll(List.of(
//                new Student("Nika", "Veronika",course),
//                new Student("Pawel", "Pawelko", course),
//                new Student("Lukasz", "Zaba", course),
//                new Student("Magdalena", "Kwiecinska", course),
//                new Student("Paulina", "Ogorzalek", course)
//        ));
//        teacherService.saveAll(List.of(new Teacher("Tomek", "Borek"),
//                new Teacher("Marcin", "Borek")));
//    }
}
