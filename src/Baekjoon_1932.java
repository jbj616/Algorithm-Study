import java.util.Scanner;

public class Baekjoon_1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] triangle = new int[n][n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                triangle[i - 1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);
            }
        }

        System.out.println(triangle[0][0]);
    }
}
