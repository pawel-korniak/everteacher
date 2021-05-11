package com.epam.jap.everteacher.syllabus;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
}
