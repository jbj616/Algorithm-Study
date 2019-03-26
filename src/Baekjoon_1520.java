
import java.util.Scanner;

public class Baekjoon_1520 {
    static int[][] map, dp;
    static int n, m;
    static int[] wx = {-1, 0, 1, 0};
    static int[] wy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = -1; //dp를 -1로 초기화
            }
        }

        System.out.println(dfs(m-1, n-1));
    }

    public static int dfs(int x, int y) {
        if (x == 0 && y == 0)
            return 1;

        if (dp[y][x] == -1) {
            dp[y][x] = 0; //방문시 0으로 체크
            for (int i = 0; i < 4; i++) {
                int ny = y + wy[i];
                int nx = x + wx[i];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (map[ny][nx] > map[y][x]) {
                        dp[y][x] += dfs(nx, ny);
                    }
                }
            }
        }
        return dp[y][x];
    }
}