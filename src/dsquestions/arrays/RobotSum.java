package dsquestions.arrays;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RobotSum {

    public static int robotSim(int[] commands, int[][] obstacles) {

        int x = 0;
        int y = 0;
        char dir = 'N';
        Set<String> obstacleSet = Stream.of(obstacles)
                .map(arr -> arr[0] + "-" + arr[1])
                .collect(Collectors.toSet());
        int max=Integer.MIN_VALUE;
        for (int command : commands) {
            if (command == -1) {
                if (dir == 'N') {
                    dir = 'E';
                } else if (dir == 'S') {
                    dir = 'W';
                } else if (dir == 'W') {
                    dir = 'N';
                } else {
                    dir = 'S';
                }
            } else if (command == -2) {
                if (dir == 'N') {
                    dir = 'W';
                } else if (dir == 'S') {
                    dir = 'E';
                } else if (dir == 'W') {
                    dir = 'S';
                } else {
                    dir = 'N';
                }
            } else {
                int newX = x;
                int newY = y;
                for (int i = 1; i <= command; i++) {
                    if (dir == 'N') {
                        newY++;
                        if (obstacleSet.contains(newX + "-" + newY)) {
                            newY--;
                            break;
                        }
                    } else if (dir == 'S') {
                        newY--;
                        if (obstacleSet.contains(newX + "-" + newY)) {
                            newY++;
                            break;
                        }
                    } else if (dir == 'W') {
                        newX--;
                        if (obstacleSet.contains(newX + "-" + newY)) {
                            newX++;
                            break;
                        }
                    } else {
                        newX++;
                        if (obstacleSet.contains(newX + "-" + newY)) {
                            newX--;
                            break;
                        }
                    }
                }
                x=newX;
                y=newY;
                max=Math.max(x*x+y*y,max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int []commands = {6,-1,-1,6};
        int [][]obstacles = {};
        System.out.println(robotSim(commands,obstacles));
    }

}
