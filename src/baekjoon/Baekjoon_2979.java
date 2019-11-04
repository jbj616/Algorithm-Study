package baekjoon;

import java.util.Scanner;

public class Baekjoon_2979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A, B, C;
        int[] time = new int[101];

        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        for(int i=0; i<3; i++){
            int a, b;
            a= sc.nextInt();
            b = sc.nextInt();

            for(int j=a; j<b; j++)
                time[j]+=1;
        }
        int sum =0;
        for(int i=1; i<=100; i++){
            if(time[i] ==1){
                sum += 1*A;
            }else if(time[i]==2){
                sum+=2*B;
            }else if(time[i]==3){
                sum+=3*C;
            }
        }

        System.out.println(sum);
    }
}
