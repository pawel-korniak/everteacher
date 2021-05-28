package com.epam.jap.everteacher.syllabus;

public interface CourseProvider {
    Course provide(String text);

    static CourseProvider getProvider() {
        return new CourseFromLocalFile();
    }
}
