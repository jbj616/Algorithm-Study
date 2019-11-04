package baekjoon;

import java.util.Scanner;

public class Baekjoon_11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] dp = new int[10][n + 1];

        for (int i = 0; i < 10; i++)
            dp[i][1] = 1;
        if (n >= 2) {
            for (int i = 0; i < 10; i++)
                dp[i][2] = 10 - i;
        }
        for (int i = 3; i <= n; i++) {
            for (int a = 0; a < 10; a++) {
                for (int b = a; b < 10; b++) {
                    dp[a][i] += dp[b][i - 1];
                }
                dp[a][i] %= 10007;
            }
        }
        int result = 0;
        for (int i = 0; i < 10; i++)
            result += dp[i][n];

        result %= 10007;
        System.out.println(result);
    }
}
