package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_4344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum;
        float avg;
        int m;

        for(int i=0; i<n; i++){
            int count = 0;
            sum = 0;
            m = sc.nextInt();
            int[] num = new int[m];
            for(int j=0; j<m; j++){
                num[j] = sc.nextInt();
                sum+=num[j];
            }
            avg = (float)sum/m;
            Arrays.sort(num);
            for (int j=0; j<num.length; j++){
                if(num[j]>avg) {
                    count = num.length - j;
                    break;
                }
            }
            System.out.printf("%.3f", 100.0 * count / m);
            System.out.println("%");
        }
    }
}
