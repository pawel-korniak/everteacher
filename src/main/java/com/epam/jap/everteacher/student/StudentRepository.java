package com.epam.jap.everteacher.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<UserDetails> findByLogin(String login);
}
