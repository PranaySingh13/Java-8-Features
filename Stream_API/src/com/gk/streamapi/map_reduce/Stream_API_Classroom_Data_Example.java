package com.gk.streamapi.map_reduce;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stream_API_Classroom_Data_Example {

	static List<Classroom> classroomList = ClassroomDao.getAllClassroomStudents();

	// 1. define a function getStudentsByCity(city) that will take cityName as
	// ARGUMENT and return all students of
	// that city.
	public static List<Student> getStudentsByCity(String city) {
		return classroomList.stream().flatMap(classroom -> classroom.getStudents().stream())
				.filter(student -> student.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
	}

	// 2. define a function getUniqueCities() that will return an array of city
	// names. cities in array must not duplicate.
	// ["pune", "jaipur","chandigarh"]
	public static List<String> getUniqueCities() {
		return classroomList.stream().flatMap(classroom -> classroom.getStudents().stream()).map(Student::getCity)
				.distinct().collect(Collectors.toList());
	}

	// 3. define a function getPassedStudentsNamesWithGradeA() that will return all
	// students who passed. passing
	// criteria will be
	// a.) marks> 33 in each subject.
	// b.) marks> 33 in each subject and overall avg > 50
	// c.) for general cat. marks> 33 in each subject and overall avg > 50
	// for obc cat. marks> 33 in each subject and overall avg > 40
	// for sc and st cat. marks> 33 in each subject only
	public static List<String> getPassedStudentsNamesWithGradeA() {
		return classroomList.stream().flatMap(classroom -> classroom.getStudents().stream())
				.filter(student -> student.getMarks().stream().allMatch(mark -> mark > 33)).map(Student::getName)
				.collect(Collectors.toList());
	}

	public static List<String> getPassedStudentsNamesWithGradeB() {
		return classroomList.stream().flatMap(classroom -> classroom.getStudents().stream())
				.filter(student -> student.getMarks().stream().allMatch(mark -> mark > 33))
				.filter(student -> student.getMarks().stream().mapToInt(i -> i).average().getAsDouble() > 50)
				.map(Student::getName).collect(Collectors.toList());
	}

	// Alternative and Better Approach

	// filter 1
	static Predicate<Student> marksInEachSubject33 = student -> student.getMarks().stream().allMatch(mark -> mark > 33);

	// filter 2
	static Predicate<Student> averageMarksGreaterThan50 = student -> student.getMarks().stream().mapToInt(i -> i)
			.average().getAsDouble() > 50;

	public static List<String> getPassedStudentsNamesWithGradeB_Alternative() {
		/*
		 * Let’s Utilize the method firstPredicate.and(secondPredicate) now.
		 * 
		 * Pass the second predicate as a parameter to the and() function on the first
		 * predicate. This signifies that the first predicate receives each instance
		 * from the stream. If the first predicate returns true, the second predicate
		 * receives the same value. Finally, the result of filter() method will be
		 * satisfied by first and second predicate’s.
		 * 
		 * You can also use p1.and(p2.and(p3) to call with multiple predicates.
		 */
		return classroomList.stream().flatMap(classroom -> classroom.getStudents().stream())
				.filter(marksInEachSubject33.and(averageMarksGreaterThan50)).map(Student::getName)
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		List<Student> studentList = getStudentsByCity("pune");
		System.out.println(studentList);

		List<String> uniqueCities = getUniqueCities();
		System.out.println(uniqueCities);

		List<String> passedStudentsNamesA = getPassedStudentsNamesWithGradeA();
		System.out.println(passedStudentsNamesA);

		List<String> passedStudentsNamesB = getPassedStudentsNamesWithGradeB();
		System.out.println(passedStudentsNamesB);

		List<String> passedStudentsNamesWithGradeB_alternative = getPassedStudentsNamesWithGradeB_Alternative();
		System.out.println(passedStudentsNamesWithGradeB_alternative);

	}

}
