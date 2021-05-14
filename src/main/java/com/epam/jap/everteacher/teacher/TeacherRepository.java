package com.epam.jap.everteacher.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    UserDetails findByName(String name);
}
