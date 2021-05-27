package com.epam.jap.everteacher.syllabus;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
public class SuperTopic {

    @GeneratedValue
    @Id
    Long id;
    String name;
    @Column(name = "topic_list")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Topic> topicList;

    public SuperTopic(String name, List<Topic> topicList) {
        this.name = name;
        this.topicList = topicList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperTopic that = (SuperTopic) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
