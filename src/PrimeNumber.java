import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumber {
    static ArrayList<Integer> prime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        prime = new ArrayList<>();

        for(int i=2; i<=n; i++) {
            prime.add(i);
        }
        for(int i=2; i<=n; i++) {
            for(int j=1; i*j<=n; j++) {
                if(prime.contains(i*j))
                    prime.remove(i*j);
            }
        }
        //에라토스테네스의 체

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            Result(k);
        }
    }

    public static void Result(int k) {

        for (int a = 0; a < prime.size(); a++) {
            for (int b = 0; b < prime.size(); b++) {
                for (int c = 0; c < prime.size(); c++) {

                    if (k == (prime.get(a) + prime.get(b) + prime.get(c))) {
                        System.out.println(prime.get(a) +" + "+ prime.get(b) +" + "+ prime.get(c));
                        return ;
                    }
                }
            }
        }
        System.out.println(0);
        return ;
    }
}