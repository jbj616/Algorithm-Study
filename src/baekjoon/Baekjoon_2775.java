package baekjoon;

import java.util.Scanner;

public class Baekjoon_2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[][] resident;

        for(int x=0; x<t; x++){

            resident = new int[15][15];
            for (int i=1; i<=14; i++)
                resident[0][i] = i;

            int a = sc.nextInt();
            int b= sc.nextInt();

            for (int i=1 ; i<=a; i++){
                for(int j=1; j<=b; j++){
                    for(int k = 1; k<=j; k++){
                        resident[i][j] += resident[i-1][k];
                    }
                }
            }

            System.out.println(resident[a][b]);
        }

    }
}
