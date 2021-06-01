package com.epam.jap.everteacher.student;

import com.epam.jap.everteacher.exceptions.UserNotFoundException;
import com.epam.jap.everteacher.syllabus.Course;
import com.epam.jap.everteacher.syllabus.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Student findById(Long id) throws UserNotFoundException {
        return studentRepository.findById(id).orElseThrow(() -> new UserNotFoundException("" + id));
    }

    public List<Student> saveAll(List<Student> students) {
        return studentRepository.saveAll(students);
    }


    public Student markTopicAsFinished(Long studentId, Long topicId) {
        Student student = studentRepository.getById(studentId);
        Topic topic = student.getCourse().allTopics().stream()
                .filter(t -> t.getId().equals(topicId))
                .findAny()
                .orElseThrow();
        student.markedAsFinished(topic);
        return studentRepository.save(student);
    }

    public Student markTopicAsUnfinished(Long studentId, Long topicId) {
        Student student = studentRepository.getById(studentId);
        Topic topic = student.getCourse().allTopics().stream()
                .filter(t -> t.getId().equals(topicId))
                .findAny()
                .orElseThrow();
        student.markAsUnfinished(topic);
        return studentRepository.save(student);
    }

    public Student markTopicAsBlocked(Long studentId, Long topicId) {
        Student student = studentRepository.getById(studentId);
        Topic topic = student.getFinishedTopics().stream().filter(t -> t.getId().equals(topicId)).findAny().orElseThrow();
        student.markedAsBlocked(topic);
        return studentRepository.save(student);
    }

    public List<Student> addStudentsToCourse(Course course) {
        var list = studentRepository.findAll();
        list.forEach(student -> student.setCourse(course));
        return studentRepository.saveAll(list);
    }

    public Student unblockTopic(Long studentId, Long topicId) {
        Student student = studentRepository.getById(studentId);
        Topic topic = student.getBlockedTopics().stream().filter(t -> t.getId().equals(topicId)).findAny().orElseThrow();
        student.unblockTopic(topic);
        return studentRepository.save(student);
    }

    public List<Student> findAllById(List<Long> id) {
        return studentRepository.findAllById(id);
    }

    public UserDetails findByLogin(String login) throws UsernameNotFoundException {
        UserDetails user = studentRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException(login));

        //if(user == null) throw new UserNotFoundException(login);
        return user;
    }
}
