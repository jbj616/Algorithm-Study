import java.util.Scanner;

public class Baekjoon_6588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = new int[1000001];

        num[1] = -1;
        for (int i=2; i<=1000000; i++){
            if(num[i] == -1)
                continue;

            int a = 2;
            while (i*a <=1000000){
                num[i*a] = -1;
                a++;
            }
        }

        while (true){
            int n = sc.nextInt();

            if(n == 0)
                break;

            boolean flag  = false;
            for(int i= 1; i<n; i++){
                if(num[i] !=-1 && num[n-i]!=-1){
                    flag = true;
                    System.out.println(n+" = "+ i + " + "+ (n-i));
                    break;
                }
            }
            if (!flag)
                System.out.println("Goldbach's conjecture is wrong.");


        }
    }
}
