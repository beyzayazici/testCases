package com.test.cases.testCase2.service;

import com.test.cases.testCase2.model.AcademicProgram;
import com.test.cases.testCase2.model.Course;
import com.test.cases.testCase2.model.Graph;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseSchedulerService {
    //1st solution : no special algorithm
    public List<Integer> firstSolution(AcademicProgram academicProgram) {
        List<Course> courses = academicProgram.getCourses();
        int totalCourseNumber = academicProgram.getTotalCourseNumber();
        LinkedList<Integer> schedule = new LinkedList<>();
        boolean[] visited = new boolean[totalCourseNumber];

        for (Course course : courses) {
            int courseNo = course.getCourseNo();
            for(int prerequireCourseNo : course.getPrerequisites()) {
                if(!visited[prerequireCourseNo]) {
                    if(visited[courseNo]) {
                        int index = schedule.indexOf(courseNo);
                        int i = 0;
                        while (i <= index) {
                            if(i == index || index == 0 || schedule.get(i) > prerequireCourseNo) {
                                schedule.add(i, prerequireCourseNo);
                                break;
                            }
                            i++;
                        }
                    }
                    else {
                        schedule.add(prerequireCourseNo);
                    }
                    visited[prerequireCourseNo] = true;
                }
            }
            if(!visited[courseNo]) {
                schedule.add(courseNo);
                visited[courseNo] = true;
            }
        }
        if(totalCourseNumber > schedule.size()) {
            addNotScheduledLessons(schedule, visited);
        }
        return schedule;
    }


    //2nd solution : Graph solution
    public void secondSolution(Graph graph, List<Integer> orderList, boolean[] isVisited, int currentNode) {
        List<Integer> neighbors = new ArrayList<>(graph.neighbors(currentNode));
        Collections.sort(neighbors);

        List<Integer> predecessors = new ArrayList<>(graph.predecessors(currentNode));
        Collections.sort(predecessors);

        int tmp = 0;
        for (int predecessor : predecessors) {
            tmp += isVisited[predecessor] ? 1 : 0;
        }

        if (tmp == predecessors.size()) {
            isVisited[currentNode] = true;
            orderList.add(currentNode);
        } else {
            return;
        }

        for (int currentNeighbor : neighbors) {
            secondSolution(graph, orderList, isVisited, currentNeighbor);
        }
    }

    public int getStartNode (Graph graph, int size) {
        int startNode = getStartNode(graph);
        int foundedNode = 0;
        boolean flag = false;
        if(size > graph.getAdjacencyList().size()) {
            for (int index = 0; index < size; index++) {
                if(!graph.getAdjacencyList().containsKey(index)) {
                    graph.addEdge(index, startNode);
                    foundedNode = index;
                    flag = true;
                }
            }
            if (flag) {
                checkPreNode(graph, size, foundedNode);
            }
            return getStartNode(graph);
        }
        return startNode;
    }

    //bfs algorithm approach
    public int[] bfsAlgorithmApproach(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegrees = new int[numCourses];

        // Build the graph and in-degrees based on prerequisites
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.computeIfAbsent(prerequisiteCourse, k -> new ArrayList<>()).add(course);
            inDegrees[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int[] schedule = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            schedule[index++] = course;
            if (graph.containsKey(course)) {
                for (int dependentCourse : graph.get(course)) {
                    inDegrees[dependentCourse]--;
                    if (inDegrees[dependentCourse] == 0) {
                        queue.offer(dependentCourse);
                    }
                }
            }
        }

        if (index != numCourses) {
            // There is a cycle in the prerequisites, no valid schedule exists
            return new int[0];
        }

        return schedule;
    }

    private void checkPreNode(Graph graph, int size, int foundedNode) {
        for (int index = 0; index < size; index++) {
            if (graph.getAdjacencyList().containsKey(index)) {
                if(graph.predecessors(index).size() == 0 && index != foundedNode) {
                    graph.addEdge(foundedNode, index);
                }
            }
        }
    }

    private int getStartNode(Graph graph) {
        Integer keyMax = null;
        int maxSize = Integer.MIN_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : graph.getAdjacencyList().entrySet()) {
            int valueSize = entry.getValue().size();
            int key = entry.getKey();
            if (valueSize > maxSize || (valueSize == maxSize && graph.predecessors(key).size() < graph.predecessors(keyMax).size())) {
                maxSize = valueSize;
                keyMax = key;
            }
        }
        return keyMax;
    }

    private void addNotScheduledLessons(List<Integer> schedule, boolean[] visited)
    {
        int index = 0;
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                schedule.add(index, i);
                index++;
            }
        }
    }

}

