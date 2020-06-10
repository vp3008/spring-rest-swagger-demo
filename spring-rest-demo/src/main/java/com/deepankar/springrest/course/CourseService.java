package com.deepankar.springrest.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	/*
	 * private List<Topic> topics = new ArrayList<>(Arrays.asList( new
	 * Topic("Spring", "Spring Framework", "Spring framework description"), new
	 * Topic("Java","Java Framework", "Java Framework Description" ), new
	 * Topic("Python", "Python Framework", "Python Framework Description") ));
	 */
	
	public List<Course> getAllCourses(String topicId){
		//return topics;
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findByTopicId(topicId).forEach(courses :: add);
		return courses;
	} 
	
	public Course getCourse(String id)
	{	 
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id).orElse(null);
	}
	
	public void addCourse(Course course)
	{
		//topics.add(topic);
		courseRepository.save(course);
	}
	
	public void updateCourse(Course course)
	{
		
		/*
		 * for(int i = 0;i < topics.size();i++) { if(id.equals(topics.get(i).getId())) {
		 * topics.set(i, topic); return; } }
		 */
		//topics.stream().filter(t -> t.getId().equals(id)).forEach(t -> topics.set(topics.indexOf(t), topic));
		
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id)
	{
		//topics.removeIf( t-> t.getId().equals(id));
		courseRepository.deleteById(id);
	}
}
