package baekjoon;

import java.util.Scanner;

public class Baekjoon_14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] T = new int[n+1];
        int[] P = new int[n+1];
        int[] dp = new int[n+2];

        for (int i=1; i<=n; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        dp[n+1] = 0;
        int max = 0;
        for (int i=n; i>=1; i--){
            if( i+T[i] <= n + 1 ){
                dp[i] = Math.max(P[i]+dp[i+T[i]], max);
                max = Math.max(dp[i], max);
            }else{
                dp[i] = max;
            }
        }

        System.out.println(dp[1]);

    }
}
