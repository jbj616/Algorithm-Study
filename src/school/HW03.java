package src.school;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HW03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();    // # of test case

        long st = System.currentTimeMillis();

        for (int t = 0; t < T; t++) {

            int n = sc.nextInt();
            int[] card = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                card[i] = sc.nextInt();
            }


            System.out.println(solve(n, card));
        }

        long et = System.currentTimeMillis();
        System.out.println((et - st) + " ms");

        sc.close();

    }

    public static int solve(int n, int[] card) {
        int[] sum = new int[n + 1];
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][i] = card[i];
        }

        for (int i = 1; i <= n; i++) {
            sum[i] += sum[i - 1] + dp[i][i];
        }

        int a = 1;
        int b = 2;

        for (int x = 2; x <= n; x++) {
            for (int y = x + 1; y <= n + 1; y++) {
                dp[a][b] = sum[b] - sum[a - 1] - Math.min(dp[a + 1][b], dp[a][b - 1]);
                a++;
                b++;
            }
            a = 1;
            b = x + 1;
        }

        System.out.println();
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        return dp[1][n];
    }
}
