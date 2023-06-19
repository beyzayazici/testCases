package com.test.cases.testCase2.model;

import com.test.cases.testCase2.model.Course;

import java.util.List;

public class AcademicProgram {

    private int totalCourseNumber;
    private List<Course> courses;
    public AcademicProgram(int totalCourseNumber, List<Course> courses) {
        this.totalCourseNumber = totalCourseNumber;
        this.courses = courses;
    }

    public int getTotalCourseNumber() {
        return totalCourseNumber;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setTotalCourseNumber(int totalCourseNumber) {
        this.totalCourseNumber = totalCourseNumber;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
