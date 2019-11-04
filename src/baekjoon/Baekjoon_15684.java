package baekjoon;

import java.util.Scanner;

public class Baekjoon_15684 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //가로선
        int t = sc.nextInt();
        int m = sc.nextInt(); //세로선
        int[][] ladder = new int[m+1][n];

        for (int i=0; i<t; i++){
            int y = sc.nextInt();
            int x = sc.nextInt();

            ladder[y][x] = 1;
        }

        for (int i=1; i<=m; i++){
            int a = 0;
            for (int j=1; j<n; j++){
                if(ladder[i][j]==1)
                    a++;
            }
            if(a%2 != 0){ //가로선이 홀수개일때
                for (int j=1; j<n; j++){
                    if(ladder[i][j]==1)
                        a++;
                }
            }
        }

    }
}
