package baekjoon;

import java.util.Scanner;

public class Baekjoon_2167 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        int[][]num = new int[n][m];

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                num[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();
        for (int a = 0; a<k; a++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int i = sc.nextInt();
            int j= sc.nextInt();
            int sum = 0;

            for (int b = x-1; b<i; b++){
                for (int c = y -1; c<j; c++){
                    sum += num[b][c];
                }
            }
            System.out.println(sum);
        }

    }
}
