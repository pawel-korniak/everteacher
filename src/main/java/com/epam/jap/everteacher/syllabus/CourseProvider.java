package com.epam.jap.everteacher.syllabus;

public interface CourseProvider {
    Course provide();
    static CourseProvider getProvider(){
        return new CourseFromFile();
    }
}
