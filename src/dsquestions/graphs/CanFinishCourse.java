package dsquestions.graphs;

public class    CanFinishCourse {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean visited[] = new boolean[numCourses + 1];
        boolean rec[] = new boolean[numCourses + 1];
        for (int i = 1; i <= numCourses; i++) {
            if (isCyclic(prerequisites, i, visited, rec)) {
                return false;
            }
        }
        return true;
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

    public static void main(String[]args){
        int[][]prerequisites={
                {1,0}
        };
        System.out.println(canFinish(2,prerequisites));
    }


}
