import java.util.Scanner;

public class HW_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            System.out.println(Pillar(n, l, r));
        }
    }
    public static long Pillar(int n, int l, int r) {
        if (n == 0 || l == 0 || r == 0) {
            return 0;
        }
        if (n == 1 && l == 1 && r == 1) {
            return 1;
        }
        return Pillar(n - 1, l - 1, r) + Pillar(n - 1, l, r - 1) + (n-2)*Pillar(n - 1, l, r);
    }
}