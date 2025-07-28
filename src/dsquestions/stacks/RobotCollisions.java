package dsquestions.stacks;

import java.util.*;
import java.util.stream.Collectors;

class Robot {
    int pos;
    int health;
    char dir;
    int index;

    public Robot(int pos, int health, char dir, int index) {
        this.pos = pos;
        this.health = health;
        this.dir = dir;
        this.index = index;
    }
}

public class RobotCollisions {
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            robots.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        }
        robots.sort(Comparator.comparingInt(a -> a.pos));
        Stack<Robot> stack = new Stack<>();
        for (Robot robot : robots) {
            if (robot.dir == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && robot.health > 0) {
                    Robot temp = stack.pop();
                    if (temp.health < robot.health) {
                        robot.health--;
                    } else if (temp.health > robot.health) {
                        temp.health--;
                        robot.health=0;
                        stack.push(temp);
                    }
                    else {
                        robot.health=0;
                    }
                }
                if(robot.health>0){
                    stack.push(robot);
                }
            }
        }
        stack.sort(Comparator.comparingInt(a -> a.index));
        return stack.stream().map(a -> a.health).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] positions = {3, 5, 2, 6}, healths = {10, 10, 15, 12};
        String directions = "RLRL";
        System.out.println(survivedRobotsHealths(positions, healths, directions));
    }
}
