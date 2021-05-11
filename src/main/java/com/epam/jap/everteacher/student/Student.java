package com.epam.jap.everteacher.student;

import com.epam.jap.everteacher.syllabus.Course;
import com.epam.jap.everteacher.syllabus.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pmw.tinylog.Logger;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
@Data
public class Student {//} implements UserDetails {
    @GeneratedValue
    @Id
    Long id;
    String name;
    @Column(name = "last_name")
    String lastName;
    @OneToOne
    Course course;
    //    String password;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "finishedtopic_student",
            joinColumns = @JoinColumn(name = "topic_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id",
                    referencedColumnName = "id"))
    List<Topic> finishedTopics;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "blockedtopic_student",
            joinColumns = @JoinColumn(name = "topic_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id",
                    referencedColumnName = "id"))
    List<Topic> blockedTopics;

    public Student(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        Logger.info("Student Constructor");
    }

    public boolean hasFinishedTopic(String topicName) {
        return finishedTopics.stream().anyMatch(topic -> topic.getName().equals(topicName));
    }

    public void markedAsFinished(Topic topic) {
        finishedTopics.add(topic);
    }

    public void markedAsBlocked(Topic topic) {
        finishedTopics.remove(topic);
        blockedTopics.add(topic);
    }

    public void unblockTopic(Topic topic) {
        blockedTopics.remove(topic);
        finishedTopics.add(topic);
    }


    //    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority("STUDENT"));
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
