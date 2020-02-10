package src.summerorwiter;

public class JumpAndTele {

    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(5000));
    }

    public static int solution(int n) {
        int count = 0;
        while (true) {
            if (n == 1) {
                break;
            }

            if (n % 2 == 0) {
                n = n / 2;
                continue;
            }

            n = n - 1;
            count++;
        }

        return count + 1;
    }

}
