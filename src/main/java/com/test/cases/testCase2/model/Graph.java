package com.test.cases.testCase2.model;

import java.util.*;

public class Graph {
    private int courseNumber;
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(int source, int destination) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());
        adjacencyList.get(source).add(destination);
    }

    public List<Integer> neighbors(int node) {
        return adjacencyList.getOrDefault(node, new ArrayList<>());
    }

    public List<Integer> predecessors(int node) {
        List<Integer> predecessors = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int key = entry.getKey();
            List<Integer> neighbors = entry.getValue();
            if (neighbors.contains(node)) {
                predecessors.add(key);
            }
        }
        return predecessors;
    }

    public Map<Integer, List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setAdjacencyList(Map<Integer, List<Integer>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }
}