package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Alpha[] = new int[26];

        String dic = sc.next();

        for (int i = 0; i < dic.length(); i++) {
            char ch = dic.charAt(i);

            if (ch >= 'a' && ch <= 'z')
                Alpha[ch - 'a']++;
            else
                Alpha[ch - 'A']++;
        }

        int max = 0;
        int max_Alpha = 0;
        boolean flag = false;
        for (int i = 0; i < 26; i++) {
            if (max < Alpha[i]) {
                max = Alpha[i];
                max_Alpha = i;
            }
        }

        Arrays.sort(Alpha);
        if (Alpha[25] == Alpha[24]) {
            System.out.println("?");
        } else
            System.out.println((char) (max_Alpha + 'A'));
    }
}
