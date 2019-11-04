package baekjoon;

import java.util.Scanner;

public class Baekjoon_1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] makeOne = new int[1000001];
        int n;

        makeOne[1] = 0;
        makeOne[2] = 1;
        makeOne[3] = 1;
        makeOne[4] = 2;
        makeOne[5] = 3;

        n = sc.nextInt();

        for(int i=3; i<=n; i++){
            int min =99999;
            if(i%3 == 0){
                min =Math.min(min,makeOne[i/3]+1);
            }
            if(i%2 == 0)
                min = Math.min(min,makeOne[i/2]+1);

            makeOne[i]=Math.min(min, makeOne[i-1]+1);

        }

        System.out.println(makeOne[n]);
    }
}
