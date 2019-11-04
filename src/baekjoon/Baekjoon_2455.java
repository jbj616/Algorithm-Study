package baekjoon;

import java.util.Scanner;

public class Baekjoon_2455 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int train = 0;
        int max = 0;

        for (int i = 0; i < 4; i++){
            train-=sc.nextInt(); //내린 사람
            train+=sc.nextInt(); //탄 사람

            max = Math.max(train, max);
        }
        System.out.println(max);
    }
}
