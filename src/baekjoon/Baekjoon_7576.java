package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_7576 {
    static int N, M;
    static Tomato[][] tomatoes;
    static boolean[][] isVisited;
    static int[] x = {-1, 0, 1, 0};
    static int[] y = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        tomatoes = new Tomato[N][M];
        isVisited = new boolean[N][M];
        ArrayList<Tomato> array = new ArrayList<>();

        for (int i = 0; i < N; i++) //입력 토마토 1일때 따로 저장.
            for (int j = 0; j < M; j++) {
                int input = sc.nextInt();
                tomatoes[i][j] = new Tomato(j, i, input);
                if (input == 1)
                    array.add(tomatoes[i][j]);
            }

        Queue<Tomato> q = new LinkedList<>(); //bfs
        for (int i = 0; i < array.size(); i++) {
            q.offer(array.get(i));
            isVisited[array.get(i).y][array.get(i).x] = true;
        }
        while (!q.isEmpty()) {
            Tomato tmp = q.poll();

            for (int i = 0;i < 4; i++) {
                int tomato_x = tmp.x + x[i];
                int tomato_y = tmp.y + y[i];

                if (tomato_x >= 0 && tomato_y >= 0 && tomato_x < M && tomato_y < N)
                    if (isVisited[tomato_y][tomato_x] == false && tomatoes[tomato_y][tomato_x].value == 0) {
                        q.offer(tomatoes[tomato_y][tomato_x]);
                        isVisited[tomato_y][tomato_x] =true;
                        tomatoes[tomato_y][tomato_x].value = tmp.value+1;
                    }
            }
        }

        int day = 0;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                if(tomatoes[i][j].value== 0){
                    flag = true;
                }else
                    day = Math.max(day, tomatoes[i][j].value);
        }

        if(flag)
            System.out.println(-1);
        else
            System.out.println(day-1);

    }
}

class Tomato {
    int x, y;
    int value;

    Tomato(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
