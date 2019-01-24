import java.util.Scanner;

public class Baekjoon_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A,B,C;
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        int total  = A*B*C;
        int[] num = new int[10];

        while (true){
            num[total%10]++;
            total = total/10;
            if(total == 0)
                break;
        }
        for(int i=0; i<10; i++)
            System.out.println(num[i]);

    }
}
