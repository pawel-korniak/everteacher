package com.epam.jap.everteacher.config;

import com.epam.jap.everteacher.student.StudentService;
import com.epam.jap.everteacher.exceptions.UserNotFoundException;
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
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Logger.info("Reach out for Username : " + login);
        UserDetails user = null;
        try {
            user = studentService.findByLogin(login);
        } catch (UsernameNotFoundException e) {
            Logger.error(e.getMessage());
            user = teacherService.findByLogin(login);
        }
        if (user==null) throw new UsernameNotFoundException(login);
        return user;
    }
}
