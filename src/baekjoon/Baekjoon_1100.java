package baekjoon;

import java.util.Scanner;

public class Baekjoon_1100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] chess = new char[8][8];
        int count  =0;
        for (int i=0; i<8; i++){
            String str = sc.next();
            for (int j=0; j<8; j++){
                chess[i][j] = str.charAt(j);
            }
        }

        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                if((i+j)%2==0){
                    if(chess[i][j] == 'F')
                        count++;
                }
            }
        }
        System.out.println(count);
    }
}
