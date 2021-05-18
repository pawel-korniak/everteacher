package com.epam.jap.everteacher.student;

public interface GroupProvider {
    GroupOfStudents provide(String text, String groupName);

    static GroupProvider getProvider() {
        return new GroupFromFile();
    }
}
