package baekjoon;

import java.util.Scanner;

public class Baekjoon_2252 {
    static int[] student;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] student = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            student[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (student[a] > student[b]) {
                while (true) {
                    if (student[a] < student[b])
                        break;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(student[i] + " ");
        }
    }


}
