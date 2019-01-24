import java.util.Scanner;
import java.util.Vector;

public class Baekjoon_10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N, X ;

        N = sc.nextInt();
        X = sc.nextInt();
        int[] num = new int[N];
        Vector<Integer>  v = new Vector<>();

        for(int i=0; i<N; i++) {
            num[i] = sc.nextInt();
            if (num[i] < X)
                v.add(num[i]);
        }
        for(int i=0; i<v.size(); i++)
            System.out.print(v.get(i)+" ");
    }
}
