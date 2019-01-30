import java.util.Scanner;

public class Baekjoon_9095 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int T = sc.nextInt();

        int[] sum = new int[11];
        sum[1] = 1;
        sum[2] = 2;
        sum[3] = 4; //1+2, 2+1. 3. 1+1+1
        sum[4] = 7; //1+1+1+1, 1+2+1 *3, 2+2, 3+1 *2
        for(int i=4; i<11; i++){
            sum[i] = sum[i-1]+sum[i-3]+sum[i-2];
        }

        for(int i=0; i<T; i++){
            int tmp = sc.nextInt();
            System.out.println(sum[tmp]);
        }
    }
}
