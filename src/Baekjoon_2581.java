import java.util.Scanner;

public class Baekjoon_2581 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int sum = 0, count = 0;
        int first_num = 0;
        int[] num = new int[N+1];
        num[1] = -1;

        for (int i = 2; i<=N; i++){ //에라토스테네스의 체 0이면 소수 -1이면 소수 아님.
            if(num[i] == 0){
                int a = 2;
                while (a*i<=N){
                    num[(a++)*i]=-1;
                }
            }
        }

        for (int i= M; i<=N; i++){
            if(num[i] == 0 ){
                if(count== 0) //범위내의 첫번째 소수 저장
                    first_num = i;
                sum+=i;
                count++;
            }
        }
        //출력
        if(count == 0)
            System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(first_num);
        }

    }
}
