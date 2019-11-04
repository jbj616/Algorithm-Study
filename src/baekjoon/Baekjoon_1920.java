package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] num1 = new int[n];

        for(int i=0; i<n; i++)
            num1[i] =sc.nextInt();

        n = sc.nextInt();
        int[] num2= new int[n];
        for (int i=0; i<n; i++)
            num2[i] = sc.nextInt();

        Arrays.sort(num1);

        for(int i=0; i<n; i++){
            int low = 0;
            int high = num1.length-1;
            boolean flag = false;

            while (low<=high){ //이진탐색
                int mid = (low+high)/2;

                if(num1[mid] == num2[i]){
                    flag  = true;
                    break;
                }else if(num1[mid] < num2[i]){
                    low = mid+1;
                }else
                    high = mid-1;
            }
            if(flag)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
