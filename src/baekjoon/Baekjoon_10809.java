package baekjoon;

import java.util.Scanner;

public class Baekjoon_10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int[] alpha = new int[26];

        for(int i=0; i<26; i++)
            alpha[i] = -1;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(alpha[(int)ch - 97] ==-1)
                alpha[(int)ch - 97] =i;
        }
        for(int i=0;i <26; i++)
            System.out.printf(alpha[i]+" ");
    }
}
