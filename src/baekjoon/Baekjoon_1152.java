package baekjoon;

import java.util.Scanner;

public class Baekjoon_1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean flag = false;
        int count = 0;
        String str = sc.nextLine();

        for(int i=0; i<str.length(); i++){
            if(flag == false && str.charAt(i)!=' ')
                flag = true;
            if(flag == true && str.charAt(i)==' ')
            {
                flag = false;
                count++;
            }
        }

        if(str.charAt(str.length()-1)!=' ')
            count++;
        System.out.println(count);
    }
}
