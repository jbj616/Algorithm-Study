import java.util.Scanner;

public class Baekjoon_2293 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coin = new int[k+1];
        int[] dp = new int[k+1];

        for(int i=1; i<=n; i++){
            coin[sc.nextInt()]++;
        }

        for (int i=1; i<=n; i++){
            for (int j=1; j<=i; i++){

            }
        }
    }
}
