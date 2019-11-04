package baekjoon;

import java.util.Scanner;

public class Baekjoon_2169 {
    static int N, M;
    static Robot[][] robot ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        robot =new Robot[N][M];

        for(int i=0; i<N; i++)
            for(int j=0; i<M; j++)
                robot[i][j] = new Robot(j, i, sc.nextInt());

        for(int i=0; i<N; i++) {
            for (int j = 0; i < M; j++){
                System.out.printf("");
            }

        }
    }
}
class Robot{
    int x, y;
    int value;
    Robot(int x, int y , int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
