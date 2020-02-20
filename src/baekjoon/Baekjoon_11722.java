package src.baekjoon;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;

public class Baekjoon_11722 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] nums = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
        }

        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (nums[j] > nums[i]) {
                    max = Math.max(max, dp[j]);
                }
            }

            if (max == 0) {
                dp[i] = 1;
            } else {
                dp[i] = max + 1;
            }
        }


        OptionalInt min = Arrays.stream(dp).max();

        System.out.println(min.getAsInt());

    }

}
