import java.util.Scanner;

public class Baekjoon_2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] pinary_num = new long[91];

        pinary_num[0] = 1;
        pinary_num[1] = 1;
        pinary_num[2] = 1;

        for (int i=3; i<=n; i++){
            pinary_num[i] = pinary_num[i-1]+pinary_num[i-2];
        }

        System.out.println(pinary_num[n]);
    }
}
