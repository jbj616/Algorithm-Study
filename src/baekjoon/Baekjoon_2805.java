package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2805 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] tree = new int[n];

        tree[0] = 0;
        for (int i = 1; i < tree.length; i++) {
            tree[i] = sc.nextInt();
        }

        Arrays.sort(tree);

        int low = 0;
        int high = n - 1;
        int mid;
        int total  = 0;

        while (low < high) {
            mid = (low + high) / 2;

            for (int i = mid; i < n; i++) {
                total = (tree[i] - tree[mid]);
            }

            if(total == m){
                break;
            }else if(total < m){
                high = mid -1;
            }else{

            }
        }
    }

}
