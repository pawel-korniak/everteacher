package com.epam.jap.everteacher.teacher;

import com.epam.jap.everteacher.student.Student;
import com.epam.jap.everteacher.student.StudentService;
import com.epam.jap.everteacher.syllabus.Course;
import com.epam.jap.everteacher.syllabus.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("teacher")
class TeacherController {

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final CourseService courseService;

    @PostMapping("save")
    Teacher saveTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping("all")
    List<Teacher> showAllTeachers() {
        return teacherService.findAllTeachers();
    }

    @GetMapping("allStudents")
    List<Student> showAll() {
        return studentService.showAll();
    }

    @GetMapping("{id}")
    Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.findById(id);
    }

    @PostMapping("addStudents/{courseId}")
    void addStudents(@PathVariable Long courseId) {
        Course course = courseService.findById(courseId);
        studentService.addStudentsToCourse(course);
    }

    @PostMapping("addTeachers/{courseId}")
    void addTeachers(@PathVariable Long courseId) {
        Course course = courseService.findById(courseId);
        teacherService.addTeachersToCourse(course);
    }

    @EventListener(ApplicationReadyEvent.class)
    void save() {
        teacherService.saveAll(List.of(new Teacher("Tomek", "Borek"),
                new Teacher("Marcin", "Borek")));
    }

    @PostMapping("block/{studentId}")
    Student markTopicAsBlocked(@RequestParam Long topicId, @PathVariable Long studentId) {
        return studentService.markTopicAsBlocked(topicId, studentId);
    }

    @PostMapping("unblock/{studentId}")
    Student unblockTopic(@RequestParam Long topicId, @PathVariable Long studentId) {
        return studentService.unblockTopic(topicId, studentId);
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
