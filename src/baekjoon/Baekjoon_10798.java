package baekjoon;

import java.util.Scanner;

public class Baekjoon_10798 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        char[][] letter = new char[5][15];

        for(int j=0; j<5; j++) {
            String str = sc.next();

            for (int i = 0; i < str.length(); i++)
                letter[j][i] = str.charAt(i);
        }

        for(int i=0; i<15; i++){
            for(int j=0; j<5;j++){
                if(letter[j][i]!=0)
                System.out.print(letter[j][i]);
            }
        }

    }
}
