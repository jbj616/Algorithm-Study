package baekjoon;

import java.util.Scanner;

public class Baekjoon_2163 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);


        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(n*(m-1) + (n-1));
    }
}
