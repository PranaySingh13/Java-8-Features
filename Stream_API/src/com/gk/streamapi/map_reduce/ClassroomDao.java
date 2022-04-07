package com.gk.streamapi.map_reduce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClassroomDao {

	public static List<Classroom> getAllClassroomStudents() {
		return Stream
				.of(new Classroom(1,
						Arrays.asList(new Student("Ayushi", 20, "pune", Arrays.asList(45, 76, 34), "general"),
								new Student("rahul", 24, "jaipur", Arrays.asList(17, 72, 34), "sc"),
								new Student("prateek", 36, "pune", Arrays.asList(22, 46, 84), "obc"),
								new Student("sagar", 56, "chandigarh", Arrays.asList(33, 36, 34), "st"),
								new Student("hanuman", 45, "jaipur", Arrays.asList(49, 26, 34), "obc"),
								new Student("ram", 25, "pune", Arrays.asList(55, 16, 34), "general"),
								new Student("laxman", 27, "jaipur", Arrays.asList(67, 52, 34), "sc"),
								new Student("raj", 36, "pune", Arrays.asList(73, 66, 84), "st"),
								new Student("vipul", 66, "chandigarh", Arrays.asList(15, 76, 34), "obc"),
								new Student("mahesh", 25, "jaipur", Arrays.asList(35, 86, 34), "st"),
								new Student("mohan", 28, "pune", Arrays.asList(45, 36, 34), "sc"),
								new Student("meena", 26, "jaipur", Arrays.asList(57, 22, 34), "sc"),
								new Student("anita", 35, "pune", Arrays.asList(33, 86, 84), "general"),
								new Student("ganesh", 59, "chandigarh", Arrays.asList(55, 96, 34), "general"),
								new Student("shankar", 43, "jaipur", Arrays.asList(65, 46, 34), "obc"))))
				.collect(Collectors.toList());
	}

}