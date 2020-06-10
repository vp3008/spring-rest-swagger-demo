package com.deepankar.springrest.course;

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

import com.deepankar.springrest.topic.Topic;
import com.deepankar.springrest.topic.TopicService;

@RestController 
@RequestMapping("/rest/topics")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	TopicService topicService;
	
	@GetMapping("/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id)
	{
		return 	courseService.getAllCourses(id);
	}
	
	@GetMapping("/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id)
	{
		return courseService.getCourse(id);
	}
	
	@PostMapping("/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId)
	{
		//course.setTopic(new Topic(topicId, "",""));
		Topic parentTopic = topicService.getTopic(topicId);
		course.setTopic(parentTopic);
		courseService.addCourse(course);
	}
	
	@PutMapping("/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id)
	{
		//course.setTopic(new Topic(topicId, "", ""));
		Topic parentTopic = topicService.getTopic(topicId);
		course.setTopic(parentTopic);
		courseService.updateCourse(course);
	}
	
	@DeleteMapping("/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id)
	{
		courseService.deleteCourse(id);
	}
}
