import java.util.Scanner;

public class Baekjoon_2517 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int[] num = new int[N];
        //int[] grade = new int[N];

        for(int i=0; i<N; i++)
            num[i] =sc.nextInt();

        for(int i=0; i<N; i++){
            int count = 1;
            for(int j=0; j<i; j++){
                if(num[j]>num[i])
                    count++;
            }
           // grade[i] = count;
            System.out.println(count);
        }
//
//        for(int i=0; i<N; i++)
//            System.out.println(grade[i]);
    }
}
