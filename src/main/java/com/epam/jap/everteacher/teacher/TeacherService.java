package com.epam.jap.everteacher.teacher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    final TeacherRepository teacherRepository;

    Teacher saveTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

}
