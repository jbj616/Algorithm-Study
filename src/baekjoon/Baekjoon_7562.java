package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_7562 {

    static Chess[][] chessGame;
    static boolean[][] isVisited;
    static int L;
    static int[] x = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] y = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        for (int t = 0; t<time; t++) {
            L = sc.nextInt();
            int startLocation_y = sc.nextInt();
            int startLocation_x = sc.nextInt();
            int arrLocation_y = sc.nextInt();
            int arrLocation_x = sc.nextInt();

            chessGame = new Chess[L][L];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < L; j++) {
                    chessGame[i][j] = new Chess(j, i);
                }
            }
            isVisited = new boolean[L][L];

            bfs(chessGame[startLocation_y][startLocation_x]);

            System.out.println(chessGame[arrLocation_y][arrLocation_x].data);
            //print();
        }

    }

    public static void print(){
        for (int i=0; i<L; i++){
            for (int j=0; j<L; j++){
                System.out.print(chessGame[i][j].data+ " ");
            }
            System.out.println();
        }
    }

    public static int bfs(Chess chess) {
        chessGame[chess.y][chess.x].data =0;

        Queue<Chess> q = new LinkedList<>();
        isVisited[chess.y][chess.x] = true;
        q.add(chess);

        while (!q.isEmpty()) {
            Chess tmp = q.poll();
            for (int i = 0; i < 8; i++) {
                int move_y = tmp.y + y[i];
                int move_x = tmp.x + x[i];

                if (move_x >= 0 && move_x < L && move_y >= 0 && move_y < L) {
                    if (!isVisited[move_y][move_x]) {

                        isVisited[move_y][move_x] = true;
                        chessGame[move_y][move_x].data = tmp.data+1;

                        q.add(chessGame[move_y][move_x]);
                    }
                }
            }
        }

        return -1;
    }
}

class Chess {

    int x;
    int y;
    int data = 0;

    Chess(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
