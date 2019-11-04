package baekjoon;

import java.util.Scanner;

public class Baekjoon_8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0;
        int count = 1;

        for(int i=0; i<n; i++){
            String tmp = sc.next();
            count = 1;
            sum =0;

            for (int j=0; j<tmp.length(); j++){
                if(tmp.charAt(j) == 'O')
                   sum = sum+count++;
                else
                    count = 1;
            }

            System.out.println(sum);
        }
    }
}
