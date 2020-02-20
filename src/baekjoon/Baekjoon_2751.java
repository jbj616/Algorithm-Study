package src.baekjoon;

import java.util.Scanner;

public class Baekjoon_2751 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[1000001];
        int[] minus = new int[1000001];
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if (tmp < 0) {
                minus[-tmp]++;
            } else {
                nums[tmp]++;
            }
        }

        for (int i = minus.length - 1; i > 0; i--) {
            while (minus[i] != 0) {
                System.out.println(-i);
                minus[i]--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != 0) {
                System.out.println(i);
                nums[i]--;
            }
        }
    }

}
