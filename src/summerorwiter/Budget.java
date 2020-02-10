package src.summerorwiter;

import java.util.Arrays;

public class Budget {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2, 5, 4}, 9));
        System.out.println(solution(new int[]{2, 2, 3, 3}, 10));
    }

    public static int solution(int[] d, int budget) {
        long sum = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
        }

        Arrays.sort(d);
        int count = 0;

        for (int i = d.length - 1; i >= 0; i--) {
            if (sum <= budget) {
                break;
            }

            count++;
            sum -= d[i];
        }

        return d.length - count;
    }

}
