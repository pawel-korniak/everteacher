package com.epam.jap.everteacher.syllabus;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {
    final TopicRepository topicRepository;

    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }

    public List<Topic> showAll() {
        return topicRepository.findAll();
    }
}
