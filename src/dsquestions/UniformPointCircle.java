package dsquestions;

import java.util.Arrays;
import java.util.Random;

public class UniformPointCircle {
    double radius, x_center, y_center;

    public UniformPointCircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }


    public double[] randPoint() {
        double angle = Math.random() * Math.PI * 2;
        double len = Math.sqrt(Math.random()) * radius;
        double[] ans = new double[2];
        ans[0] = x_center + Math.cos(angle) * len;
        ans[1] = y_center + Math.sin(angle) * len;
        return ans;
    }

    public static void main(String[] args) {
        UniformPointCircle uniformPointCircle = new UniformPointCircle(7.5, 1.5, 2.5);
        System.out.println(Arrays.toString(uniformPointCircle.randPoint()));
    }
}
