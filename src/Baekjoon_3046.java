import java.util.Scanner;

public class Baekjoon_3046 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int R1 = sc.nextInt();
        int S = sc.nextInt();

        int R2 = S*2 - R1;

        System.out.println(R2);
    }
}
