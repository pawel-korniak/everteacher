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
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "topic_supertopic",
            joinColumns = @JoinColumn(name = "topic_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "supertopic_id",
                    referencedColumnName = "id"))
    List<Topic> topicList;

    public SuperTopic(String name, List<Topic> topicList) {
        this.name = name;
        this.topicList = topicList;
    }
}
