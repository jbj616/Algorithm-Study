import java.util.Scanner;

public class Baekjoon_2293 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();
        int k= sc.nextInt();
        int[] coin = new int[10001];
        int[] dp = new int[10001];

        for (int i=0; i<n; i++)
        coin[sc.nextInt()]++;

        for(int i=1; i<=k; i++){
            for(int j=1; j<=i; j++){
                dp[i]  = Math.max(dp[i], coin[j]+dp[i-j]);
            }
        }
        System.out.println(dp[k]);
    }
}
