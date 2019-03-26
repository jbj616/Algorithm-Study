import java.util.Scanner;

public class Baekjoon_1051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = 1;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();

            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int a = 1;
                while (true) {
                    if (i + a * 1 < n && j + a * 1 < m) {
                        if (map[i][j] == map[i + a * 1][j] && map[i][j] == map[i][j + a * 1] && map[i][j] == map[i + a * 1][j + a * 1]) {
                            max = Math.max(max, a + 1);
                        }
                        a++;

                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(max * max);
    }
}
