package com.epam.jap.everteacher.teacher;

import com.epam.jap.everteacher.syllabus.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    final TeacherRepository teacherRepository;

    Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    public List<Teacher> saveAll(List<Teacher> teachers) {
        return teacherRepository.saveAll(teachers);
    }

    public Teacher signTeacherToCourse(Teacher teacher, Course course) {
        teacher.setCourse(course);
        return teacherRepository.save(teacher);
    }

    public Teacher findById(Long id) {
        return teacherRepository.findById(id).orElseThrow();
    }
}
