import java.util.Scanner;

public class Baekjoon_1094 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();
        int count =0;

        int[] num = new int[7];
        for(int i=0; i<7; i++)
            num[i] = (int)Math.pow(2, i);

        for (int i=6; i>=0; i--){
            if(n>=num[i]){
                count++;
                n-=num[i];
            }
            if(n == 0)
                break;
        }
        System.out.println(count);
    }
}
