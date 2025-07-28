package dsquestions.graphs;

import java.util.Stack;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean visited[] = new boolean[numCourses + 1];
        boolean rec[] = new boolean[numCourses + 1];
        int[] result = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCyclic(prerequisites, i, visited, rec)) {
                    return new int[0];
                }
            }
        }
        visited = new boolean[numCourses + 1];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                topologicalSort(prerequisites, i, visited, stack);
            }
        }
        int i = result.length - 1;
        while (!stack.isEmpty()) {
            result[i--] = stack.pop();
        }
        return result;

    }

    private static boolean isCyclic(int[][] prerequisites, int src, boolean[] visited, boolean[] rec) {
        if (rec[src]) return true;
        if (visited[src]) return false;
        rec[src] = true;
        visited[src] = true;
        for (int[] edge : prerequisites) {
            if (edge[0] == src) {
                if (isCyclic(prerequisites, edge[1], visited, rec)) {
                    return true;
                }

            }
        }
        rec[src] = false;
        return false;
    }

    private void topologicalSort(int[][] prerequisites, int src, boolean[] visited, Stack<Integer> stack) {
        visited[src] = true;
        for (int edges[] : prerequisites) {
            if (edges[0] == src) {
                if (!visited[edges[1]]) {
                    topologicalSort(prerequisites, edges[1], visited, stack);
                }
            }
        }
        stack.push(src);
    }
}
