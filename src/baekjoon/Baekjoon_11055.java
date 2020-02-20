package src.baekjoon;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Baekjoon_11055 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] dp = new int[n + 1];

        dp[1] = nums[1];
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j]);
                }
            }

            if (max == 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + max;
            }
        }

        OptionalInt max = Arrays.stream(dp).max();

        System.out.println(max.getAsInt());
    }

}
