package com.gk.streamapi.map_reduce;

import java.util.List;

public class Classroom {
    private int numberOfStudents;
    private List<Student> students;

    public Classroom(int numberOfStudents, List<Student> students) {
        this.numberOfStudents = numberOfStudents;
        this.students = students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "numberOfStudents=" + numberOfStudents +
                ", students=" + students +
                '}';
    }
}
