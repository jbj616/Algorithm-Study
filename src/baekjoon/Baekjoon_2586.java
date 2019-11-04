package baekjoon;

import java.util.Scanner;

public class Baekjoon_2586 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;

        int[] water = new int[sc.nextInt()]; // 호수
        boolean[] isVisted = new boolean[water.length]; //호수 방문 체크
        int n = sc.nextInt();
        int[] firewagonLeft  =new int[n]; //소방차
        int[] firewagonRight = new int[n];

        for(int i=0; i<water.length; i++)
            water[i] = sc.nextInt();


        for(int i=0; i<n; i++){
            int tmp = sc.nextInt();
            firewagonLeft[i] = tmp;
            firewagonRight[i] = tmp;
        }

        while (true){
            for(int i=0; i<n; i++){
                if(firewagonLeft[i]>0)
                    firewagonLeft[i]--;
                if (firewagonRight[i]<firewagonRight.length)
                    firewagonRight[i]++;


            }


        }


    }
}
