package com.test.cases.testCase2.controller;

import com.test.cases.testCase2.model.Graph;
import com.test.cases.testCase2.populator.impl.AcademicProgramConvertor;
import com.test.cases.testCase2.service.CourseSchedulerService;
import com.test.cases.testCase2.model.AcademicProgram;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AcademicProgramController {
    @Resource
    private CourseSchedulerService courseSchedulerService;
    @Resource
    private AcademicProgramConvertor academicProgramConvertor;

    @PostMapping("/getScheduledProgram")
    public ResponseEntity<String> getScheduledProgram(@RequestBody AcademicProgram academicProgram) {
        Graph graph = new Graph();
        academicProgramConvertor.populate(academicProgram, graph);
        int courseNumber = graph.getCourseNumber();
        int startNode = courseSchedulerService.getStartNode(graph, courseNumber);
        boolean[] isVisited = new boolean[courseNumber];
        List<Integer> list = new ArrayList<>();
        courseSchedulerService.secondSolution(graph, list, isVisited, startNode);
        return ResponseEntity.ok(list.toString());
    }
}
