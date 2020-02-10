package src.summerorwiter;

import java.util.Arrays;

public class BuyCookie {

    public static void main(String[] args) {

        System.out.println(solution(6, 3));
    }

    public static long solution(int width, int height) {

        double y = ((double) height / width + height % width);
        long sum = 0;

        for (int i = 1; i < width; i++) {
            double hello = i * y;
            System.out.println(hello);
            sum += (long) hello;
        }

        return sum;
    }
}
