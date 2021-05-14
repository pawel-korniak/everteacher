package com.epam.jap.everteacher.student;

import com.epam.jap.everteacher.syllabus.Course;
import com.epam.jap.everteacher.syllabus.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
@Data
public class Student implements UserDetails {

    @GeneratedValue
    @Id
    Long id;
    String name;
    @Column(name = "last_name")
    String lastName;
    @OneToOne
    Course course;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Topic> finishedTopics;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Topic> blockedTopics;

    public Student(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Student(String nika, String s, Course course) {
        name = nika;
        lastName = s;
        this.course = course;
    }

    public boolean hasFinishedTopic(String topicName) {
        return finishedTopics.stream().anyMatch(topic -> topic.getName().equals(topicName));
    }

    public boolean hasBlockedTopic(String topicName) {
        return blockedTopics.stream().anyMatch(topic -> topic.getName().equals(topicName));
    }

    public void markedAsFinished(Topic topic) {
        finishedTopics.add(topic);
    }

    public void markedAsBlocked(Topic topic) {
        markAsUnfinished(topic);
        blockedTopics.add(topic);
    }

    public void unblockTopic(Topic topic) {
        blockedTopics.remove(topic);
        finishedTopics.add(topic);
    }

    public void markAsUnfinished(Topic topic) {
        finishedTopics.remove(topic);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_STUDENT"));
    }

    @Override
    public String getPassword() {
        return "{noop}" + lastName;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
