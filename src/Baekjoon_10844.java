import java.util.Scanner;

public class Baekjoon_10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [][] dp  = new int[101][10];
        int[] array = new int[101];

        for(int i=1; i<=9; i++)
         dp[1][i] = 1;
        array[1] =9;

        for(int i=1; i<=8;i++){
            dp[2][i] = 2;
        }
        dp[2][9] = 1;
        array[2] = 17;

        for(int i=3; i<=n; i++){

            dp[i][1] = (dp[i-1][2]+dp[i-2][1])%1000000000;
            for(int j=2; j<=8; j++)
                dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
            dp[i][9] = dp[i-1][8]%1000000000;

            for(int j=1; j<=9; j++){
                array[i] =(array[i]+dp[i][j])%1000000000;
            }
        }
        System.out.println(array[n]);
    }
}
