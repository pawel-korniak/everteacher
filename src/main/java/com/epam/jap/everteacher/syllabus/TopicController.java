package com.epam.jap.everteacher.syllabus;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("topic")
public class TopicController {
    final TopicService topicService;

    @PostMapping("save")
    public Topic save(@RequestBody Topic topic) {
        return topicService.save(topic);
    }

    @GetMapping()
    public List<Topic> showAll() {
        return topicService.showAll();
    }
}
