package com.epam.jap.everteacher.syllabus;

interface CourseProvider {
    Course provide();
    static CourseProvider getProvider(){
        return new CourseFromFile();
    }
}
