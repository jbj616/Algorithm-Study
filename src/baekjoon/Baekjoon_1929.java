package baekjoon;

import java.util.Scanner;

public class Baekjoon_1929 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        for(int i = m; i<=n; i++){
            boolean flag = false;
            for(int j=2; j<i; j++){
                if(i%j==0){
                    flag = true;
                    break;
                }
            }
            if(i == 1)
                flag = true;
            if(!flag)
                System.out.println(i);
        }
    }
}