package baekjoon;

import java.util.Scanner;

public class Baekjoon_9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        long[] triangle = new long[101];

        triangle[1] = 1;
        triangle[2] = 1;
        triangle[3] = 1;
        triangle[4] = 2;
        triangle[5] = 2;
        triangle[6] = 3;

        for(int i=7; i<=100; i++){
            triangle[i] = triangle[i-1]+triangle[i-5];
        }

        int n = sc.nextInt();
        for(int i=0; i<n; i++)
            System.out.println(triangle[sc.nextInt()]);

    }
}
