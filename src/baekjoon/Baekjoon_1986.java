package baekjoon;

import java.util.Scanner;

public class Baekjoon_1986 {
    static int[] Knight_X = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] Knight_Y = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] Queen_X = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] Queen_Y = {0, 1, 1, 1, 0, -1, -1, -1};
    static int N, M;
    static int[][] chessBoard;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int count = 0;
        chessBoard = new int[N][M]; // 체스판 1: queen 2: knight 3: pawn 위치

        int k = sc.nextInt();
        for (int i = 0; i < k; i++)
            chessBoard[sc.nextInt() - 1][sc.nextInt() - 1] = 1;

        k = sc.nextInt();
        for (int i = 0; i < k; i++)
            chessBoard[sc.nextInt() - 1][sc.nextInt() - 1] = 2;

        k = sc.nextInt();
        for (int i = 0; i < k; i++)
            chessBoard[sc.nextInt() - 1][sc.nextInt() - 1] = 3;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (chessBoard[i][j] == 1)
                    Queen(j, i);
                else if (chessBoard[i][j] == 2)
                    Knight(j, i);
            }
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (chessBoard[i][j] == 0) //체스판이 0이면 Knight나 Queen의 이동 경로에 없다.
                    count++;

        System.out.println(count);
    }
    public static void Knight(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int knightX = x + Knight_X[i];
            int knightY = y + Knight_Y[i];

            if (knightX >= 0 && knightX < M && knightY < N && knightY >= 0)
                if (chessBoard[knightY][knightX] == 0) //Knight 이동 경로 체크
                    chessBoard[knightY][knightX] = -1;
        }
    }
    public static void Queen(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int queenX = x + Queen_X[i];
            int queenY = y + Queen_Y[i];

            while (queenX >= 0 && queenX < M && queenY < N && queenY >= 0 && chessBoard[queenY][queenX] <= 0) {
                chessBoard[queenY][queenX] = -1; //Queen 이동 경로 체크
                queenX += Queen_X[i];
                queenY += Queen_Y[i];
            }
        }
    }
}
