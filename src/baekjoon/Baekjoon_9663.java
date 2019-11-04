package baekjoon;

import java.util.Scanner;

public class Baekjoon_9663 {
    static int count = 0; //성공 횟
    static int[] chess_x = new int[16];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i=0; i<n ;i++){
            chess_x[0] = i;
            nQueen(i, 0);
        }
        System.out.println(count);
    }
    public static void nQueen(int x, int y){
        for (int i=0; i<y; i++){
            if(chess_x[i] == x ||Math.abs(x-chess_x[i])== y-i) //같은 열, 대각선 체크
                return ;
        }

        if(y==n-1){
            count++;
            return;
        }

        for (int i=0; i<n; i++){
            chess_x[y+1] = i;
            nQueen(i, y+1);
        }
    }
}
