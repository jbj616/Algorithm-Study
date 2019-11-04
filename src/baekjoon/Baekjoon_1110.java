package baekjoon;

import java.util.Scanner;

public class Baekjoon_1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cycle = 0;
        int origin =  n;
        int sum ;

        while(true){
            sum = n/10 + n%10;

            n = (n%10) *10 +sum%10;
            cycle++;
            if(n == origin)
                break;
        }
        System.out.println(cycle);
    }
}
