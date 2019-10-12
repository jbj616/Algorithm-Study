import java.util.Scanner;

public class Baekjoon_1904 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = 0;

        int[] dp = new int[1000001];

        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2])%15746;
        }

        System.out.println(dp[n]);

//        if (n == 1) {
//            result = 1;
//        } else if (n % 2 == 0) {
//            int k = n / 2;
//            for (int i = 1; i <= k; i++) {
//                System.out.println(k + i - 1);
//                result += fac[k + i - 1] / (fac[i] * fac[k - i + 1]);
//            }
//            result += 1;
//            result%=15746;
//
//        } else {
//            int k = n / 2;
//            for (int i = 1; i <= k; i++) {
//                result += fac[k + i] / (fac[2 * i - 1] * fac[k - i + 1]);
//            }
//            result += 1;
//        }

//        System.out.println(result);
    }

}
