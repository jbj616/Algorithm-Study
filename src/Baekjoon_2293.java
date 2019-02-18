import java.util.Scanner;

public class Baekjoon_2293 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coin = new int[k+1];
        int[] dp = new int[k+1];

        for(int i=1; i<=n; i++){
            coin[sc.nextInt()]++;
        }
        for(int i=1; i<=k; i++)
            System.out.print(coin[i]+" ");
        System.out.println();

        for (int i=1; i<=k; i++){
            for(int j=1; j<=i; j++){
                if(coin[j] !=0 &&dp[i-j]!=0)
                    dp[i] = Math.max(dp[i], coin[j]+dp[i-j]);
                if(i == j && coin[i] !=0)
                    dp[i] = Math.max(dp[i], coin[j]+dp[i-j]);
            }
        }

        for(int i=1; i<=k; i++)
            System.out.print(dp[i]+" ");
        System.out.println();

        System.out.println(dp[k]);
    }
}
