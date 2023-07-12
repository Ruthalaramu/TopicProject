package com.example.firstproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class TopicService {


     @Autowired
    private TopicRepository topicRepository;
    
  private List<Topic>  topics=  new ArrayList<>(Arrays.asList(
      new Topic( "1","Spring","Spring is used crate the applications very accurately"),
       new Topic( "2","Java","java is a programming language , using java we can solve complex probles very easily"),
        new Topic( "3","python ","python is also an programing language")
     ));

     public List<Topic> getAllTopics(){
      List<Topic> topics= new ArrayList<>();
         topicRepository.findAll().forEach(topics::add);
         return topics;

     }
     public Topic getTopic(String id){
      return  topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

      
       
     }
     public void addTopic(Topic topic){
        topicRepository.save(topic) ;
     }
   public void updateTopic(String id, Topic topic) {

      // for(int i=0;i<topics.size();i++){
       
      //    Topic t=topics.get(i);
      //    if(t.getId().equals(id)){
      //       topics.set( i, topic);
      //       return;

      //    }
      // }
      topicRepository.save(topic);
   }
public void deleteTopics(String id) {

   // for(int i=0;i<topics.size();i++){
   //    Topic t=topics.get(i);
   //    if(t.getId().equals(id)){
   //        topics.remove(topics.get(i));
   //    }
   // }
     topicRepository.delete(null);
   
     }
   }
   