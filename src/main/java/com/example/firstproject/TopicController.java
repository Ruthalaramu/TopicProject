package com.example.firstproject;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

    @Autowired
    private TopicService TopicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
     return TopicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopics( @PathVariable String id){
        return TopicService.getTopic(id);
    }

    @RequestMapping(method=RequestMethod.POST,value = "/topics")
    public void addTopic( @RequestBody Topic topic){

          TopicService.addTopic(topic);
    }
     @RequestMapping(method=RequestMethod.PUT,value = "/topics/{id}")
    public void updateTopic( @RequestBody Topic topic , @PathVariable String id){

          TopicService.updateTopic(id,topic);
    }
     @RequestMapping(method=RequestMethod.DELETE,value = "/topics/{id}")
    public void deleteTopics(  @PathVariable String id){

          TopicService.deleteTopics(id);
    }
    
}
