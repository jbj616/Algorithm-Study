package baekjoon;

import java.util.Scanner;

public class Baekjoon_10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();
            int n = sc.nextInt();


            if (n % height != 0) {
                if ((n / height + 1) < 10)
                    System.out.println(n % height + "0" + (n / height + 1));
                else
                    System.out.println(n % height + "" + (n / height + 1));

            } else {
                if ((n / height) < 10)
                    System.out.println(height + "0" + (n / height));
                else
                    System.out.println(height + "" + (n / height));
            }

        }
    }
}
