package com.deepankar.springrest.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	/*
	 * private List<Topic> topics = new ArrayList<>(Arrays.asList( new
	 * Topic("Spring", "Spring Framework", "Spring framework description"), new
	 * Topic("Java","Java Framework", "Java Framework Description" ), new
	 * Topic("Python", "Python Framework", "Python Framework Description") ));
	 */
	
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics :: add);
		return topics;
	}
	
	public Topic getTopic(String id)
	{	 
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id).orElse(null);
	}
	
	public void addTopic(Topic topic)
	{
		//topics.add(topic);
		topicRepository.save(topic);
	}
	
	public void updateTopic(String id, Topic topic)
	{
		
		/*
		 * for(int i = 0;i < topics.size();i++) { if(id.equals(topics.get(i).getId())) {
		 * topics.set(i, topic); return; } }
		 */
		//topics.stream().filter(t -> t.getId().equals(id)).forEach(t -> topics.set(topics.indexOf(t), topic));
		
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id)
	{
		//topics.removeIf( t-> t.getId().equals(id));
		topicRepository.deleteById(id);
	}
}
