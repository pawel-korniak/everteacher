package com.epam.jap.everteacher.student;

import org.pmw.tinylog.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class GroupFromFile implements GroupProvider{
    @Override
    public GroupOfStudents provide(String text, String groupName) {
        Logger.info("text = " + text);
        Logger.info("groupName = " + groupName);
        return new GroupOfStudents(groupName.split("\\.")[0], getListFromString(text));
    }

    List<Student> getListFromString(String text) {
        List<Student> students = text.lines()
                .map(s -> new Student(s.split(",")[0],s.split(",")[1]))
                .collect(Collectors.toList());

        Logger.info("students " + students);
        return students;
    }


}
