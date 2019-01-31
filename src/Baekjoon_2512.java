import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2512 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        int[] array = new int[n];

        for(int i=0; i<n; i++)
            array[i] = sc.nextInt();
        int total = sc.nextInt();

        int sum = 0;
        for(int i=0; i<n; i++)
            sum+=array[i];
        Arrays.sort(array);

        if(sum>total){
            int max =total/n;
            for(int i=0; i<n-1; i++){
                total= total-array[i];
                max= Math.max(max, total/(n-i-1));
            }
            System.out.println(max);
        }else
            System.out.println(array[n-1]);
    }
}
