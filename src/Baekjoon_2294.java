import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2294 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] coin = new int[n];
        int k = sc.nextInt();

        int[] dp = new int[10001];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        Arrays.sort(coin);

        for (int i = 1; i <= k; i++) {
            dp[i] = -1;
        }

        for (int i=0; i<n; i++){
            for (int j = 1; j<=k; j++){
                if(j>=coin[i] && dp[j-coin[i]]!=-1){
                    if(dp[j]==-1)
                        dp[j] = dp[j-coin[i]]+1;
                    else
                        dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
                }
            }
        }

        System.out.println(dp[k]);
    }
}
