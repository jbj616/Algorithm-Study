import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2217 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N =sc.nextInt();
        int[] lope = new int[N];
        int max = 0;
        for(int i=0;i<N; i++){
            lope[i] = sc.nextInt();
        }

        Arrays.sort(lope);

        for(int i=0; i<N; i++){
            max = Math.max(max, lope[i]*(N-i));
        }
        System.out.println(max);
    }

}
