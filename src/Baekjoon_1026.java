import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon_1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum =0;
        int n = sc.nextInt();
        int[] array = new int[n];
        int[] array2 = new int[n];

        for(int i=0; i<n; i++){
            array[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            array2[i] = sc.nextInt();
        }

        Arrays.sort(array);
        Arrays.sort(array2);


        for(int i=0; i<n; i++){
            sum+= (array[i]*array2[n-1-i]);
        }
        System.out.println(sum);
    }
}
