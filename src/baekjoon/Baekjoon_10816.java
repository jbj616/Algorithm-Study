package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_10816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        int[] card = new int[n];
        for (int i=0; i<n; i++)
            card[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] card2 = new int[m];
        for (int i=0; i<m; i++)
            card2[i] = sc.nextInt();


        for (int i=0; i<card2.length; i++){
            if(Arrays.binarySearch(card, card2[i])>=0)
                System.out.print(1+" ");
            else
                System.out.print(0+" ");
            System.out.println(Arrays.binarySearch(card, card2[i]));
        }
    }
}
