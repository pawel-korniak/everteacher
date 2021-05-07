package com.epam.jap.everteacher.syllabus;

import org.springframework.data.jpa.repository.JpaRepository;

interface CourseRepository extends JpaRepository<Course, Long> {
}
