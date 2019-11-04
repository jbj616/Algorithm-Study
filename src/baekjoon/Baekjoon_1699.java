package baekjoon;

import java.util.Scanner;

public class Baekjoon_1699 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int[] dp = new int[100001];
    dp[1] = 1;

    for (int i=2; i<=n; i++){
      double val = Math.sqrt(i);
      int val2 = (int)val;
      if (i == val2*val2){
        dp[i] = 1;
      }else{
        int min = 1222121;
        for (int j =val2; j>0; j--){
          min = Math.min(1+ dp[i-j*j],min);
          dp[i] = min;
        }
      }
    }
    System.out.println(dp[n]);
  }
}
