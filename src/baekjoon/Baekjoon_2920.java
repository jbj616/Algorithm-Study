package baekjoon;

import java.util.Scanner;

public class Baekjoon_2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ascending = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] descending = {8, 7, 6, 5, 4, 3, 2, 1};
        int flag_1=0, flag_2 = 0;
        int[] input = new int[8];
        for (int i = 0; i < 8; i++) {
            input[i] = sc.nextInt();
        }

        for(int i=0; i<8; i++){
            if(ascending[i] != input[i]) {
                flag_1 = -1;
                break;
            }
        }
        for(int i=0; i<8; i++){
            if(descending[i] != input[i]) {
                flag_2 = -1;
                break;
            }
        }

        if(flag_1 == -1 && flag_2==-1)
            System.out.println("mixed");
        else if(flag_1 ==0)
            System.out.println("ascending");
        else
            System.out.println("descending");
    }
}
