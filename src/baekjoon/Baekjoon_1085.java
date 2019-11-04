package baekjoon;

import java.util.Scanner;

public class Baekjoon_1085 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int min = Math.min(Math.abs(x-w), Math.abs(w-x));
        min = Math.min(min, Math.min(Math.abs(h-y), Math.abs(y-h)));
        min  = Math.min(min, Math.min(x, y));

        System.out.println(min);
    }
}
