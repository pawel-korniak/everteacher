package com.epam.jap.everteacher.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

interface StudentRepository extends JpaRepository<Student, Long> {

    UserDetails findByName(String name);

    UserDetails findByLogin(String login);
}
