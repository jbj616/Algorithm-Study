import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_3985 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int[] cake = new int[L+1];

        int n = sc.nextInt();
        int[] person = new int[n+1];
        int maxperson =-1;
        int max = 0;
        int gap, gapmax =0;
        int gapPerson=-1;

        for(int i =1; i<=n; i++){
            int p = sc.nextInt();
            int k = sc.nextInt();

            for(int j=p; j<=k; j++){
                if(cake[j] ==0) {
                    cake[j] = i;
                }
            }
            gap = k-p+1;
            if(gapmax <gap)
            {
                gapmax = gap;
                gapPerson = i;
            }
        }

        for(int i=1; i<=L; i++)
            if(cake[i]!=0) {
                person[cake[i]]++;
            }

        for (int i=1; i<=n; i++)
            if(max<person[i]){
                max = person[i];
                maxperson = i;
            }
        System.out.println(gapPerson);
        System.out.println(maxperson);
    }
}
