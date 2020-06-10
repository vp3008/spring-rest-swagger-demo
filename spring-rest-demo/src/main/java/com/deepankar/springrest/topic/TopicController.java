package com.deepankar.springrest.topic;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest")
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topics")
	@ApiOperation(value = "find all topics",
				response = Topic.class)
	public List<Topic> getAllTopics()
	{
		return 	topicService.getAllTopics();
	}
	
	@GetMapping("/topics/{id}")
	@ApiOperation(value = "find topic by id", 
			notes = "provide id to look up specific topic from the DB",
			response = Topic.class)
	public Topic getTopic(@PathVariable String id)
	{
		return topicService.getTopic(id);
	}
	
	@PostMapping("/topics")
	public void addTopic(@RequestBody Topic topic)
	{
		topicService.addTopic(topic);
	}
	
	@PutMapping("/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id)
	{
		topicService.updateTopic(id, topic);
	}
	
	@DeleteMapping("/topics/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		topicService.deleteTopic(id); 
	}
}
