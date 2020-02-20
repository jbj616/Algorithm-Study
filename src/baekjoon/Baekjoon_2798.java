package src.baekjoon;

import java.util.Scanner;

public class Baekjoon_2798 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int m = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(blackJack(nums, m));
    }

    public static int blackJack(int[] arr, int m) {
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int sum = arr[i] + arr[j] + arr[k] - m;

                    if (sum == 0) {
                        return m;
                    } else if (sum < 0) {
                        min = Math.max(min, sum);
                    } else {
                        continue;
                    }
                }
            }
        }

        return m + min;
    }
}
