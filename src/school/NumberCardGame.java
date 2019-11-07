package school;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class NumberCardGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n/2];
        int[] A = new int[n/2];
        int[] B = new int[n/2];
        Deque<Integer> dq = new LinkedList<>();

        for (int i=0; i<n; i++){
            dq.add(sc.nextInt());
        }
        A[0] = dq.pollFirst();
        B[0] = dq.pollLast();
        dp[0] = Math.max(A[0], B[0]);
        int i = 1;
        while (!dq.isEmpty() || dq.size()!=1){
            int left = dq.pollFirst();
            int right = dq.pollLast();


        }
    }
}
