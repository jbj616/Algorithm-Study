package baekjoon;

import java.util.Scanner;

public class Baekjoon_1978 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int n = sc.nextInt();

        int count =n;
        for(int i=0; i<n; i++){
            int tmp = sc.nextInt();

            if(tmp == 1)
                count--;

            for(int j=2; j<tmp; j++){
                if(tmp%j == 0) {
                    count--;
                    break;
                }
            }

        }
        System.out.println(count);
    }
}
