package com.epam.jap.everteacher.student;

import com.epam.jap.everteacher.syllabus.Topic;
import com.epam.jap.everteacher.syllabus.TopicService;
import lombok.RequiredArgsConstructor;
import org.pmw.tinylog.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {
    final StudentService studentService;
    final TopicService topicService;

    @PostMapping("save")
    public Student add(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping
    public List<Student> showAll() {
        return studentService.showAll();
    }

    @GetMapping("show")
    public List<Student> show(@RequestParam String topicName) {
        return studentService.showAll(topicName);
    }

    @GetMapping("update/{id}")
    public Student updateStudent(@RequestParam String topicName,@PathVariable Long id){
        return studentService.updateTopic(topicName,id);
    }

//    @GetMapping("addTopic")
//    public Student addTopicToStudent(@RequestParam Long studentId,@RequestParam Long topicId){
//        Student student = studentService.findById(studentId);
//        topicService.showAll();
//
//    }

    @GetMapping("addTopics")
    public List<Student> addTopicsToStudents() {
        final List<Topic> topics = topicService.showAll();
        Logger.info("List of topics from DB " + topics);
        var students = studentService.showAll();
        Logger.info("List of students from DB " + students);
        students.forEach(student -> student.addTopics(topics));
        Logger.info("List of students with topics DB " + students);
        return studentService.saveAll(students);
    }

}
