package com.epam.jap.everteacher.student;

import com.epam.jap.everteacher.syllabus.Topic;
import lombok.RequiredArgsConstructor;
import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentService {
    final StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> showAll() {
        return studentRepository.findAll();
    }

    public List<Student> showAll(String topicName) {
        return studentRepository.findAll().stream().filter(student -> student.hasTopic(topicName)).collect(Collectors.toList());
    }

    public Student findById(Long id){
        return studentRepository.findById(id).orElseThrow();
    }

    public List<Student> saveAll(List<Student> students){
        return studentRepository.saveAll(students);
    }

    public Student updateTopic(String topicName,Long id) {
        Student student = studentRepository.getById(id);
        Logger.info("students topics before HUGE change: " + student.getTopics());
        student.getTopics().stream()
                .filter(topic -> topic.getName().equals(topicName))
                .forEach(topic -> topic.setName(topicName + " done."));
        Logger.info("students topics after HUGE change: " + student.getTopics());
        studentRepository.save(student);
        return student;
    }
}
