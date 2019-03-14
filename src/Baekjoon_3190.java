import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon_3190 {
    static Pos[][] map;
    static Deque<Pos> q;
    static int locationX, locationY, N;
    static int time = 0;
    static int[] tmpX = {1, 0, -1, 0};
    static int[] tmpY = {0, +1, 0, -1};
    static int dir = 0; //0: 동 1: 남 2: 서 3: 북
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new Pos[N + 1][N + 1];
        q = new LinkedList<>();

        locationX = locationY = 1;
        int k = sc.nextInt(); //사과 개수

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                map[i][j] = new Pos(j, i);
            }
        }
        q.addFirst(map[1][1]);
        for (int i = 0; i < k; i++) {
            map[sc.nextInt()][sc.nextInt()].value = 1;// 사과 위치
        }

        k = sc.nextInt();
        Going(k);

        System.out.println(time);

    }

    public static void Going(int k) {
        for (int a = 0; a < k; a++) {
            int x = sc.nextInt() - time;
            char order = sc.next().charAt(0);

            for (int i = 0; i < x; i++) {
                time++;
                //벽에 부딪칠때
                if (locationX + tmpX[dir] == 0 || locationX + tmpX[dir] == N + 1 ||
                        locationY + tmpY[dir] == 0 || locationY + tmpY[dir] == N + 1) {
                    return;
                }
                //꼬리에 부딪칠때
                if (q.contains(map[locationY + tmpY[dir]][locationX + tmpX[dir]]))
                    return;

                Move();

            }
            //방향 전환
            if (order == 'L') {
                if (dir == 0)
                    dir = 3;
                else
                    dir--;

            } else if (order == 'D') {
                if (dir == 3)
                    dir = 0;
                else
                    dir++;
            }
        }
        while (true) {
            time++;
            if (locationX + tmpX[dir] == 0 || locationX + tmpX[dir] == N + 1 ||
                    locationY + tmpY[dir] == 0 || locationY + tmpY[dir] == N + 1) {
                return;
            }

            if (q.contains(map[locationY + tmpY[dir]][locationX + tmpX[dir]]))
                return;

            Move();
        }
    }

    public static void Move() {
        //1초당 이동
        if (map[locationY + tmpY[dir]][locationX + tmpX[dir]].value != 1) {
            q.pollLast();
        } else {
            map[locationY + tmpY[dir]][locationX + tmpX[dir]].value = 0;
        }
        q.addFirst(map[locationY + tmpY[dir]][locationX + tmpX[dir]]);

        locationX += tmpX[dir];
        locationY += tmpY[dir];
    }
}

class Pos {
    int x, y;
    int value;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

