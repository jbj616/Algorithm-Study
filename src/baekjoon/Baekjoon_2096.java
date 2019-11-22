package baekjoon;

import java.util.Scanner;

public class Baekjoon_2096 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] maps = new int[n+1][3];
        int[][] dp = new int[n+1][3];

        for (int i=1; i<=n; i++){
            maps[i][0] = sc.nextInt();
            maps[i][1] = sc.nextInt();
            maps[i][2] = sc.nextInt();
        }

        for (int i=1; i<=n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1])+maps[i][0];
            dp[i][1] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2])+maps[i][1];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2])+maps[i][2];
        }
        int max = Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]);

        for (int i=1; i<=n; i++){
            dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1])+maps[i][0];
            dp[i][1] = Math.min(Math.min(dp[i-1][0], dp[i-1][1]), dp[i-1][2])+maps[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2])+maps[i][2];
        }
        int min = Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
        System.out.println(max+" "+min);
    }
}
