
import java.util.Scanner;

public class Baekjoon_2222 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = 0; j < 10; j++)
                sum += sc.nextInt();

            System.out.println("#" + (i + 1) + " " + sum / 10);
        }
    }
}
