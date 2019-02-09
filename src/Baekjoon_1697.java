
import java.util.Scanner;

public class Baekjoon_1697 {
    static int k;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();
        k= sc.nextInt();
        int count = 0;

        while(n <k){
            n = n*2;
            count++;
        }
        int gap = Math.min(n-k, Math.abs(n/2- k));

        System.out.println(gap);

        for(int i = count; i>0; i--){
           count += gap/Math.pow(2, i);
           gap = gap%((int)Math.pow(2, i));
        }

        if(gap == 1)
            count++;

        System.out.println(count);
    }

}
