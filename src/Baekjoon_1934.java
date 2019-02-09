import java.util.Scanner;

public class Baekjoon_1934 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt();
        for(int k=0; k<n; k++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            int max_div = 1;
            int min_mul = 1;

            for (int i = 1; i <= min; i++) { //최대 공약수
                if (min % i == 0 && max % i == 0)
                    max_div = i;
            }

            min = min / max_div;
            max = max / max_div;//A = a  x GCD / B = b x GCD (a, b는 서로소)
            min_mul = min * max * max_div; //LCM = a x b x GCD = A x B / GCD

            System.out.println(min_mul);
        }
    }
}
