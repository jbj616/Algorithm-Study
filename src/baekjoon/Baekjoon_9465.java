package baekjoon;

import java.util.Scanner;

public class Baekjoon_9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();

            int[][] dp = new int[2][n + 1];
            int[][] sticker = new int[2][n + 1];

            for (int i = 1; i <= n; i++)
                sticker[0][i] = sc.nextInt();

            for (int i = 1; i <= n; i++)
                sticker[1][i] = sc.nextInt();
            //dp[1], dp[2] 설
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];
            dp[0][2] = sticker[1][1] + sticker[0][2];
            dp[1][2] = sticker[0][1] + sticker[1][2];


            for (int i = 3; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + sticker[1][i];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
