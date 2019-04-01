import java.util.Scanner;

public class Baekjoon_1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int two = 0;
        int five = 0;

        for (int i = 1; i <= n; i++) {
            int tmp = i;
            if (tmp % 2 == 0) {
                while (true) {
                    if (tmp == 0 || tmp % 2 != 0) {
                        break;
                    }

                    tmp /= 2;
                    two++;
                }
            }

            if (tmp % 5 == 0) {
                while (true) {
                    if (tmp == 0 || tmp % 5 != 0) {
                        break;
                    }

                    tmp /= 5;
                    five++;
                }
            }
        }

        System.out.println(Math.min(two, five));
    }
}
