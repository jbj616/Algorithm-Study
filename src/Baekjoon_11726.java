import java.util.Scanner;

public class Baekjoon_11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] tile = new int[1001];
        tile[1] =1;
        tile[2] = 2;

        for(int i=3; i<=n; i++)
            tile[i] = (tile[i-1]+tile[i-2])%10007;

        System.out.println(tile[n]);
    }
}
