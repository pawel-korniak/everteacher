package com.epam.jap.everteacher.syllabus;

import org.pmw.tinylog.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CourseFromFile implements CourseProvider {
    private final Path path = Paths.get("course.txt");

    @Override
    public Course provide() {
        return new Course(findValueFromGivenKey("name:"), getCourseDate("start:"), getCourseDate("end:"), createTopics());
    }

    private List<SuperTopic> createTopics() {
        List<SuperTopic> superTopics = new ArrayList<>();
        String syllabus = getSyllabus();

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

    private String getSyllabus() {
        String data = "";
        try (Stream<String> lines = Files.lines(path)) {
            data = lines.collect(Collectors.joining(" "));
        } catch (IOException e) {
            Logger.error(e.getMessage());
        }
        Logger.info("Data : " + data);
        return data.split("syllabus:")[1];
    }


    private LocalDate getCourseDate(String key) {
        String start = findValueFromGivenKey(key);
        return LocalDate.parse(start);
    }

    private String findValueFromGivenKey(String key) {
        String matchingLine = "";
        try (Stream<String> lines = Files.lines(path)) {
            matchingLine = lines.filter(s -> s.startsWith(key)).findAny().orElseThrow();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matchingLine.split(" ", 2)[1];
    }
}
