package com.test.cases.testCase2.model;

import java.util.Collections;
import java.util.List;

public class Course {
    private final int courseNo;
    private final List<Integer> prerequisites;

    public Course(int courseNo, List<Integer> prerequisites) {
        this.courseNo = courseNo;
        this.prerequisites = prerequisites;
        Collections.sort(prerequisites);
    }

    public int getCourseNo() {
        return courseNo;
    }

    public List<Integer> getPrerequisites() {
        return prerequisites;
    }
}
