package com.epam.jap.everteacher.syllabus;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {
    final CourseRepository courseRepository;

    public List<Course> showAll() {
        return courseRepository.findAll();
    }

    public void save(Course course) {
        courseRepository.save(course);
    }

    public Course findById(Long courseId) {
        return courseRepository.getById(courseId);
    }

    public Course saveCourseFromFile(String text) {
        Course course = CourseProvider.getProvider().provide(text);
        return courseRepository.save(course);
    }
}
