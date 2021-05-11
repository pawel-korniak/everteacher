package com.epam.jap.everteacher.teacher;

import com.epam.jap.everteacher.student.StudentService;
import com.epam.jap.everteacher.syllabus.Course;
import com.epam.jap.everteacher.syllabus.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("teachers")
class TeacherController {

    private final TeacherService teacherService;
    private final CourseService courseService;

    @PostMapping
    ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherService.saveTeacher(teacher), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Teacher>> findAllTeachers() {
        return new ResponseEntity<>(teacherService.findAllTeachers(),HttpStatus.OK);
    }

    @GetMapping("{teacherId}")
    ResponseEntity<Teacher> findById(@PathVariable Long teacherId) {
        return new ResponseEntity<>(teacherService.findById(teacherId),HttpStatus.OK);
    }

    @PostMapping("{teacherId}/sign-to-course/{courseId}")
    ResponseEntity<Teacher> signTeacherToCourse(@PathVariable Long teacherId, @PathVariable Long courseId) {
        Course course = courseService.findById(courseId);
        Teacher teacher = teacherService.findById(teacherId);
        return new ResponseEntity<>(teacherService.signTeacherToCourse(teacher,course),HttpStatus.OK);
    }

    @EventListener(ApplicationReadyEvent.class)
    void save() {
        teacherService.saveAll(List.of(new Teacher("Tomek", "Borek"),
                new Teacher("Marcin", "Borek")));
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
