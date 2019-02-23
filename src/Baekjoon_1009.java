import java.util.Scanner;

public class Baekjoon_1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(Distributed_processing(a, b));
        }
    }

    public static int Distributed_processing(int a, int b) {
        a = a % 10;
        if (a == 1 || a == 5 || a == 6 ) {
            return a;
        } else if (a == 4|| a == 9) {
            if (b % 2 == 0)
                return (a*a)%10;
            else
                return a;
        } else if (a == 0) {
            return 10;
        } else {
            if (b % 4 == 1) {
                return a;
            } else if (b % 4 == 2) {
                return (a * a) % 10;
            } else if (b % 4 == 3) {
                return (a * a * a) % 10;
            } else {
                return (a * a * a * a) % 10;
            }
        }
    }
}
