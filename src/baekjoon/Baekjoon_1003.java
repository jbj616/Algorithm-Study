package baekjoon;

import java.util.Scanner;

public class Baekjoon_1003 {
    static int[] count_zero;
    static int[] count_one;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        count_one = new int[41];
        count_zero = new int[41];
        count_zero[0] = 1;
        count_one[0] = 0;
        count_zero[1] = 0;
        count_one[1] = 1;

        for (int i = 2; i <= 40; i++) {
            count_one[i] = count_one[i - 1] + count_one[i - 2];
            count_zero[i] = count_zero[i - 1] + count_zero[i - 2];
        }
        for (int i = 0; i < t; i++) {

            int n = sc.nextInt();

            System.out.println(count_zero[n] + " " + count_one[n]);
        }
    }


}
