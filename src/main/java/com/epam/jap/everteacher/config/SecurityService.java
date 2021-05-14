package com.epam.jap.everteacher.config;

import com.epam.jap.everteacher.student.StudentService;
import com.epam.jap.everteacher.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.pmw.tinylog.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SecurityService implements UserDetailsService {

    private final StudentService studentService;
    private final TeacherService teacherService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Logger.info("Reach out for Username : " + name);
        UserDetails user = studentService.findByName(name);
        if (user==null) user = teacherService.findByName(name);
        return user;
    }
}