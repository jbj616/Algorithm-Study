package baekjoon;

import java.util.Scanner;

public class Baekjoon_1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            int d =(x1-x2)*(x1-x2)+ (y1-y2)*(y1-y2);

            if(d> (r1+r2)*(r1+r2)){
                System.out.println(0);
            }else if(d==(r1+r2)*(r1+r2)){
                System.out.println(1);
            }else{
                if(d ==0 && r1 == r2){
                    System.out.println(-1);
                }else if((r2-r1)*(r2-r1)> d){
                    System.out.println(0);
                }else if((r2-r1)*(r2-r1)== d){
                    System.out.println(1);
                }else{
                    System.out.println(2);
                }
            }


        }
    }
}
