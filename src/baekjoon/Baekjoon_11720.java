package baekjoon;

import java.util.Scanner;

public class Baekjoon_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        String hi;
        hi = sc.next();
        int sum =0;
        for(int i=0; i<n; i++)
            sum+=hi.charAt(i)-48;

        System.out.println(sum);
    }
}
