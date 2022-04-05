package com.gk.streamapi.map_reduce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClassroomDao {

	public static List<Classroom> getAllClassroomStudents() {
		return Stream
				.of(new Classroom(1,
						Arrays.asList(new Student("Ayushi", 20, "pune", Arrays.asList(45, 76, 34), "general"))))
				.collect(Collectors.toList());
	}

}