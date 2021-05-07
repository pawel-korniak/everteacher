package com.epam.jap.everteacher.teacher;

import com.epam.jap.everteacher.syllabus.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "teacher")
public class Teacher {//} implements UserDetails {

    @GeneratedValue
    @Id
    Long id;
    String name;
    @Column(name = "last_name")
    String lastName;
    @OneToOne
    Course course;

    public Teacher(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    //    String password;
//    String role = "TEACHER";


//    public Teacher(String name, String lastName, String password) {
//        this.name = name;
//        this.lastName = lastName;
//        this.password = password;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority("ROLE_TEACHER"));
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return name;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
