import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2156 {
    static int[] grape;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] dp = new int[n];
        grape = new int[n];


        for(int i=0; i<n; i++){
            grape[i] =sc.nextInt();
        }
        if(n == 1){
            System.out.println(grape[0]);
        }else if(n == 2){
            System.out.println(grape[0]+grape[1]);
        }else if(n == 3){
            Arrays.sort(grape);
            System.out.println(grape[1]+grape[2]);
        }else{
            dp[0] =grape[0];
            dp[1] = dp[0]+grape[1];
            dp[2] = Math.max(Math.max(grape[0]+grape[1],grape[2]+grape[1]), grape[0]+grape[2]);
            for(int i=3; i<n; i++){
                int a = grape[i]+dp[i-2];
                int b =grape[i]+grape[i-1]+dp[i-3];
              int c = dp[i-1];


                dp[i] = Math.max(Math.max(a,b),c);
            }
            System.out.println(dp[n-1]);
        }

    }

}
