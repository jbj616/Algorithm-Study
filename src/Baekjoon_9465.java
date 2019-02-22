import java.util.Scanner;

public class Baekjoon_9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt();

        for(int i=0; i< n; i++){
            int k = sc.nextInt();

            int[][] sticker = new int[2][k+1];
            int[] dp = new int[k+1];

            for(int a=0; a<2; a++){
                for(int b =1; b<=k; b++){
                    sticker[a][b]=sc.nextInt();
                }
            }
            int a = 0;
            if(sticker[0][1]<sticker[1][1])
                dp[1] = sticker[0][1];
            else{
                a = 1;
                dp[1] =sticker[1][1];
            }

            
        }
    }
}
