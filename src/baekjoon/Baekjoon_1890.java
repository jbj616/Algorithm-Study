package baekjoon;

import java.util.Scanner;

public class Baekjoon_1890 {
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][n];
        long[][] dp = new long[n][n];

        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                map[i][j] = sc.nextInt();

        dp[0][0] = 1;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if(dp[i][j] != 0 ){
                    if(map[i][j]+j<n){
                        if(j == n-1)
                            break;
                        if(map[i][j]!= 0)
                            dp[i][map[i][j]+j] +=dp[i][j];
                        else
                            dp[i][j] = 0;
                    }
                }
            }

            for (int j=0; j<n; j++){
                if(dp[i][j] != 0){
                    if(map[i][j]+i<n){
                        if(i == n-1)
                            break;
                        if(map[i][j]!= 0)
                            dp[map[i][j]+i][j] +=dp[i][j];
                        else
                            dp[i][j] = 0;
                    }
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
