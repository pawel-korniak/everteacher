package com.epam.jap.everteacher.syllabus;

import org.pmw.tinylog.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseFromFile implements CourseProvider {
    @Override
    public Course provide(String text) {
        return new Course(findValueFromGivenKey("name:", text), getCourseDate("start:", text), getCourseDate("end:", text), createTopics(text));

    }

    private List<SuperTopic> createTopics(String text) {
        List<SuperTopic> superTopics = new ArrayList<>();
        String syllabus = getSyllabus(text);

        var topics = syllabus.split("\\d\\. ");
        for (int i = 1; i < topics.length; i++) {
            var subs = topics[i].split("- ");
            superTopics.add(new SuperTopic(subs[0], getTopicList(subs)));
        }
        return superTopics;
    }

    private List<Topic> getTopicList(String[] subs) {
        List<Topic> topicList = new ArrayList<>();
        Logger.info("topic : " + subs[0]);
        for (int j = 1; j < subs.length; j++) {
            Logger.info("sub : " + subs[j]);
            topicList.add(new Topic(subs[j]));
        }
        return topicList;
    }

    private String getSyllabus(String text) {
        return text.lines().collect(Collectors.joining(" ")).split("syllabus:")[1];
    }


    private LocalDate getCourseDate(String key, String text) {
        String start = findValueFromGivenKey(key, text);
        return LocalDate.parse(start);
    }

    private String findValueFromGivenKey(String key, String text) {
        return text.lines().filter(s -> s.startsWith(key)).findAny().orElseThrow().split(" ", 2)[1];
    }
}
