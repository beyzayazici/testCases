package com.test.cases.testCase2.populator.impl;

import com.test.cases.testCase2.model.AcademicProgram;
import com.test.cases.testCase2.model.Course;
import com.test.cases.testCase2.model.Graph;
import com.test.cases.testCase2.populator.ProgramConvertor;
import org.springframework.stereotype.Component;

@Component
public class AcademicProgramConvertor implements ProgramConvertor {

    @Override
    public void populate(AcademicProgram source, Graph target) {
        target.setCourseNumber(source.getTotalCourseNumber());
        for(Course course : source.getCourses()) {
            for(int i : course.getPrerequisites()) {
                target.addEdge(i, course.getCourseNo());
            }
        }
    }
}
