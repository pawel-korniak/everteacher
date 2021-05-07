package com.epam.jap.everteacher.student;

import com.epam.jap.everteacher.syllabus.Course;
import com.epam.jap.everteacher.syllabus.Topic;
import lombok.RequiredArgsConstructor;
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
        return studentRepository.findAll().stream().filter(student -> student.hasFinishedTopic(topicName)).collect(Collectors.toList());
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public List<Student> saveAll(List<Student> students) {
        return studentRepository.saveAll(students);
    }


    public Student markTopicAsFinished(Long topicId, Long studentId) {
        Student student = studentRepository.getById(studentId);
        Topic topic = student.getCourse().allTopics().stream()
                .filter(t -> t.getId().equals(topicId))
                .findAny()
                .orElseThrow();
        student.markedAsFinished(topic);
        return studentRepository.save(student);
    }

    public Student markTopicAsBlocked(Long topicId, Long studentId) {
        Student student = studentRepository.getById(studentId);
        Topic topic = student.getFinishedTopics().stream().filter(t -> t.getId().equals(topicId)).findAny().orElseThrow();
        student.markedAsBlocked(topic);
        return studentRepository.save(student);
    }

    public void addStudentsToCourse(Course course) {
        var list = studentRepository.findAll();
        list.forEach(student -> student.setCourse(course));
        studentRepository.saveAll(list);
    }

    public Student unblockTopic(Long topicId, Long studentId) {
        Student student = studentRepository.getById(studentId);
        Topic topic = student.getBlockedTopics().stream().filter(t -> t.getId().equals(topicId)).findAny().orElseThrow();
        student.unblockTopic(topic);
        return studentRepository.save(student);
    }
}
