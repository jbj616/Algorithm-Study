import java.util.Scanner;

public class Baekjoon_2579 {
    static int n;
    static int[] stairs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        stairs = new int[n+1];
        int[] dp = new int[n+1];


        for (int i = 1; i <= n; i++)
            stairs[i] = sc.nextInt();

        dp[1] = stairs[1]; //10
        dp[2] = stairs[1] + stairs[2]; //10 + 20
        // 10 + 20

        //System.out.println(UpStair(0));

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i] + stairs[i - 1]);
            // System.out.println("i"+dp[i]);
        }

        //for (int i=0; i<n; i++)
        //   System.out.println("="+dp[i]);
        System.out.println(dp[n]);
    }

    public static int UpStair(int a) {
        int sum1 = 0, sum2 = 0;
        int sum = stairs[a];
        if (a > n - 4) {
            if (a == n - 2)
                sum += stairs[a + 1];
            else if (a == n - 3)
                sum += Math.max(stairs[a + 1], stairs[a + 2]);
        } else {
            sum1 += stairs[a + 1];
            sum1 += UpStair(a + 3);
            sum2 += UpStair(a + 2);
            sum += Math.max(sum1, sum2);
        }
        return sum;
    }
}
