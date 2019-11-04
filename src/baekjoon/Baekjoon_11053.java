package baekjoon;

import java.util.Scanner;

public class Baekjoon_11053 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();
        int[] num = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1; i<=n;i++)
            num[i] =sc.nextInt();
        dp[1] = 1;

        for (int i=2; i<=n; i++){
            for (int j=1; j<i; j++){
                if(num[i]>num[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
                else
                    dp[i] = Math.max(dp[i], 1);
            }
        }

        int max = 0;
        for(int i=1; i<=n; i++)
            max = Math.max(max, dp[i]);

        System.out.println(max);
    }
}
