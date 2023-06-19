package com.test.cases;

import com.test.cases.testCase2.model.AcademicProgram;
import com.test.cases.testCase2.model.Course;
import com.test.cases.testCase2.populator.impl.AcademicProgramConvertor;
import com.test.cases.testCase2.service.CourseSchedulerService;
import com.test.cases.testCase2.model.Graph;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcademicProgramTestCases {
    private AcademicProgram academicProgram;

    @Resource
    private CourseSchedulerService courseScheduler;

    @Resource
    private AcademicProgramConvertor academicProgramConvertor;

    @BeforeEach
    public void setup() {
        courseScheduler = new CourseSchedulerService();
        academicProgramConvertor = new AcademicProgramConvertor();
    }

    @Test
    public void testCase1() {
        int courseNumber = 4;
        //1st solution
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1, Arrays.asList(0)));
        courses.add(new Course(2, Arrays.asList(0)));
        courses.add(new Course(3, Arrays.asList(1,2)));
        academicProgram = new AcademicProgram(courseNumber, courses);
        List<Integer> list = courseScheduler.firstSolution(academicProgram);
        assertEquals(list, Arrays.asList(0,1,2,3));

        //2nd solution
        Graph graph = new Graph();
        academicProgramConvertor.populate(academicProgram, graph);
        int startNode = courseScheduler.getStartNode(graph, courseNumber);
        boolean[] isVisited = new boolean[courseNumber];
        List<Integer> list2 = new ArrayList<>();
        courseScheduler.secondSolution(graph, list2, isVisited, startNode);
        assertEquals(list2, Arrays.asList(0,1,2,3));

    }

    @Test
    public void testCase2() {
        int courseNumber = 7;
        //1st solution
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(0, Arrays.asList(1,2)));
        courses.add(new Course(1, Arrays.asList(3)));
        courses.add(new Course(2, Arrays.asList(3)));
        courses.add(new Course(3, Arrays.asList(4,5)));
        courses.add(new Course(4, Arrays.asList(6)));
        courses.add(new Course(5, Arrays.asList(6)));
        academicProgram = new AcademicProgram(courseNumber, courses);
        List<Integer> list = courseScheduler.firstSolution(academicProgram);
        assertEquals(list, Arrays.asList(6,4,5,3,1,2,0));

        //2nd solution
        Graph graph = new Graph();
        academicProgramConvertor.populate(academicProgram, graph);
        int startNode = courseScheduler.getStartNode(graph, courseNumber);
        boolean[] isVisited = new boolean[courseNumber];
        List<Integer> list2 = new ArrayList<>();
        courseScheduler.secondSolution(graph, list2, isVisited, startNode);
        assertEquals(list2, Arrays.asList(6,4,5,3,1,2,0));
    }

    @Test
    public void testCase3() {
        int courseNumber = 8;
        //1st solution
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(4, Arrays.asList(0,2)));
        courses.add(new Course(0, Arrays.asList(1,6)));
        courses.add(new Course(2, Arrays.asList(3,7)));
        courses.add(new Course(1, Arrays.asList(5)));
        courses.add(new Course(6, Arrays.asList(5)));
        courses.add(new Course(3, Arrays.asList(5)));
        courses.add(new Course(7, Arrays.asList(5)));
        academicProgram = new AcademicProgram(courseNumber, courses);
        List<Integer> list = courseScheduler.firstSolution(academicProgram);
        assertEquals(list, Arrays.asList(5,1,3,6,0,7,2,4));

        //2nd solution
        Graph graph = new Graph();
        academicProgramConvertor.populate(academicProgram, graph);
        int startNode = courseScheduler.getStartNode(graph, courseNumber);
        boolean[] isVisited = new boolean[courseNumber];
        List<Integer> list2 = new ArrayList<>();
        courseScheduler.secondSolution(graph, list2, isVisited, startNode);
        assertEquals(list2, Arrays.asList(5,1,3,6,0,7,2,4));

    }

    @Test
    public void testCase4() {
        int courseNumber = 4;
        //1st solution
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(2, Arrays.asList(1,3)));
        academicProgram = new AcademicProgram(courseNumber, courses);
        List<Integer> list = courseScheduler.firstSolution(academicProgram);
        assertEquals(list, Arrays.asList(0,1,3,2));

        //2nd solution
        Graph graph = new Graph();
        academicProgramConvertor.populate(academicProgram, graph);
        int startNode = courseScheduler.getStartNode(graph, courseNumber);
        boolean[] isVisited = new boolean[courseNumber];
        List<Integer> list2 = new ArrayList<>();
        courseScheduler.secondSolution(graph, list2, isVisited, startNode);
        assertEquals(list2, Arrays.asList(0,1,3,2));
    }

}
