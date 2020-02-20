package src.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2468 {

    static Region[][] map;
    static boolean[][] isVisited;
    static int count = 0;
    static int[] x = {0, 1, 0, -1};
    static int[] y = {1, 0, -1, 0};
    static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int max = 1;

        map = new Region[n + 1][n + 1];
        int deep = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = new Region(j, i, sc.nextInt());
                deep = Math.max(deep, map[i][j].height);
            }
        }

        for (int t = 0; t <= deep; t++) {
            isVisited = new boolean[n + 1][n + 1];
            count = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (!isVisited[i][j] && map[i][j].isSafe(t)) {
                        bfs(map[i][j], t);
                        count++;

                    }
                }
            }

            max = Math.max(max, count);

        }

        System.out.println(count);

    }

    public static void bfs(Region region, int limit) {
        Queue<Region> q = new LinkedList<>();

        isVisited[region.y][region.x] = true;
        q.add(region);

        while (!q.isEmpty()) {
            Region tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int region_x = tmp.x + x[i];
                int region_y = tmp.y + y[i];

                if (region_x > 0 && region_x <= n) {
                    if (region_y > 0 && region_y <= n) {
                        if (!isVisited[region_y][region_x] && map[region_y][region_x].isSafe(limit)) {
                            isVisited[region_y][region_x] = true;

                            q.add(map[region_y][region_x]);
                        }
                    }
                }
            }
        }
    }

}

class Region {

    int x;
    int y;
    int height;

    Region(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    boolean isSafe(int limit) {
        return height > limit;
    }
}