package com.gk.streamapi.map_reduce;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	public static List<String> getPassedStudentsNamesWithGradeC() {

		List<Student> generalCategoryStudents = classroomList.stream()
				.flatMap(classroom -> classroom.getStudents().stream())
				.filter(student -> student.getCategory() == "general").collect(Collectors.toList());
		List<Student> obcCategoryStudents = classroomList.stream()
				.flatMap(classroom -> classroom.getStudents().stream())
				.filter(student -> student.getCategory() == "obc").collect(Collectors.toList());

		List<Student> scCategoryStudents = classroomList.stream().flatMap(classroom -> classroom.getStudents().stream())
				.filter(student -> student.getCategory() == "sc").collect(Collectors.toList());

		List<Student> stCategoryStudents = classroomList.stream().flatMap(classroom -> classroom.getStudents().stream())
				.filter(student -> student.getCategory() == "st").collect(Collectors.toList());

		List<String> generalPassedStudents = generalCategoryStudents.stream()
				.filter(student -> student.getMarks().stream().allMatch(mark -> mark > 33))
				.filter(student -> student.getMarks().stream().mapToInt(i -> i).average().getAsDouble() > 50)
				.map(Student::getName).collect(Collectors.toList());

		List<String> obcPassedStudents = obcCategoryStudents.stream()
				.filter(student -> student.getMarks().stream().allMatch(mark -> mark > 33))
				.filter(student -> student.getMarks().stream().mapToInt(i -> i).average().getAsDouble() > 40)
				.map(Student::getName).collect(Collectors.toList());

		List<String> scPassedStudents = scCategoryStudents.stream()
				.filter(student -> student.getMarks().stream().allMatch(mark -> mark > 33)).map(Student::getName)
				.collect(Collectors.toList());

		List<String> stPassedStudents = stCategoryStudents.stream()
				.filter(student -> student.getMarks().stream().allMatch(mark -> mark > 33)).map(Student::getName)
				.collect(Collectors.toList());

		// combining all list
		List<String> PassedStudentsNamesWithGradeC = Stream
				.of(generalPassedStudents, obcPassedStudents, scPassedStudents, stPassedStudents)
				.flatMap(Collection::stream).collect(Collectors.toList());

		return PassedStudentsNamesWithGradeC;

	}

	public static void printCitiesTopper() {
		List<Student> puneStudents = classroomList.stream().flatMap(classroom -> classroom.getStudents().stream())
				.filter(student -> student.getCity() == "pune").collect(Collectors.toList());
		List<Student> jaipurStudents = classroomList.stream().flatMap(classroom -> classroom.getStudents().stream())
				.filter(student -> student.getCity() == "jaipur").collect(Collectors.toList());
		List<Student> chandigarhStudents = classroomList.stream().flatMap(classroom -> classroom.getStudents().stream())
				.filter(student -> student.getCity() == "chandigarh").collect(Collectors.toList());

		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(4, 5, 6);
		List<Integer> list3 = Arrays.asList(7, 8, 9);

		int list1sum = list1.stream().reduce(Integer::sum).get();
		int list2sum = list2.stream().reduce(Integer::sum).get();
		int list3sum = list3.stream().reduce(Integer::sum).get();

		int maximumSumOfAllList = Arrays.asList(list1sum, list2sum, list3sum).stream().mapToInt(i -> i).max()
				.getAsInt();
		
		System.out.println(maximumSumOfAllList);

		List<Integer> puneStudentsSum = puneStudents.stream()
				.map(student -> student.getMarks().stream().reduce(Integer::sum).get()).collect(Collectors.toList());
		List<Integer> jaipurStudentsSum = jaipurStudents.stream()
				.map(student -> student.getMarks().stream().reduce(Integer::sum).get()).collect(Collectors.toList());
		List<Integer> chandigarhStudentsSum = chandigarhStudents.stream()
				.map(student -> student.getMarks().stream().reduce(Integer::sum).get()).collect(Collectors.toList());
		System.out.println("---------->" + puneStudentsSum);
		System.out.println("---------->" + jaipurStudentsSum);
		System.out.println("---------->" + chandigarhStudentsSum);
		
		

	}

	public static void main(String[] args) {
		List<Student> studentList = getStudentsByCity("pune");
		System.out.println(studentList);

		List<String> uniqueCities = getUniqueCities();
		System.out.println(uniqueCities);

		List<String> getPassedStudentsNamesWithGradeA = getPassedStudentsNamesWithGradeA();
		System.out.println(getPassedStudentsNamesWithGradeA);

		List<String> getPassedStudentsNamesWithGradeB = getPassedStudentsNamesWithGradeB();
		System.out.println(getPassedStudentsNamesWithGradeB);

		List<String> passedStudentsNamesWithGradeB_alternative = getPassedStudentsNamesWithGradeB_Alternative();
		System.out.println(passedStudentsNamesWithGradeB_alternative);

		List<String> getPassedStudentsNamesWithGradeC = getPassedStudentsNamesWithGradeC();
		System.out.println(getPassedStudentsNamesWithGradeC);
		
		printCitiesTopper();

	}

}
