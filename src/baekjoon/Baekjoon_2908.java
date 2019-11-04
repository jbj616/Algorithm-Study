package baekjoon;

import java.util.Scanner;

public class Baekjoon_2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int backA = 0;
        int backB = 0;

        while (true){
            backA = backA*10+A%10;
            A = A /10;

            if(A == 0)
                break;
        }
        while (true){
            backB= backB*10+B%10;
            B = B /10;

            if(B == 0)
                break;
        }
        System.out.println(Math.max(backA, backB));
    }
}
