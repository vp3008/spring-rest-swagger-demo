package com.deepankar.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Java8SolutionFunctionalInterfaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carrol", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Matthew", "Arnold", 39),
				new Person("Charlotte", "Bronte", 39)
				);
		
		//Step 1. Sort names by firstName
		
		//Step 2. Create a method that prints all elements in the list
		
		//Step 3. Create a method that prints all people that have names beginning with 'C'

		Collections.sort(people, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
		
		//printing the list
		System.out.println("printing the sorted list");
		printConditionally(people, p -> true, p -> System.out.println(p));
		
		System.out.println("printing the names starting with C");
		printConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));

	}
	
	 static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer)
	 {
		 for(Person p : people)
		 {
			 if(predicate.test(p))
			 {
				 consumer.accept(p);
			 }
		 }
	 }
	
}
