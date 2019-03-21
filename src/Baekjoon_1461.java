
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon_1461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] book = new int[n+1];
        book[0] = 0;
        int sum = 0;

        for (int i=1; i<= n; i++){
            book[i] = sc.nextInt();
        }

        Arrays.sort(book);
        int k = Arrays.binarySearch(book, 0);

        if(book[0]<0 && book[n]>0)
        {
            int tmp = 0;
            if(-book[0]>book[n])
                tmp = -book[0];
            else
                tmp = book[n];

            for(int i=0; i<k; i+=m){
                sum+=-book[i];
            }
            for (int i=n; i>=k+1; i-=m){
                sum+=book[i];
            }

            sum *=2;
            sum -=tmp;
        }else if(book[0] == 0){
            for (int i=n; i>=1; i-=m){
                sum+=book[i];
            }
            sum *=2;
            sum-=book[n];
        }else if(book[n] == 0){
            for(int i=0; i<n; i+=m){
                sum+=-book[i];
            }
            sum*=2;
            sum-=-book[0];
        }

        System.out.println(sum);
    }
}
