import java.util.Scanner;

public class Baekjoon_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0;
        int tmp, max =0;
        for(int i=0; i<n; i++){
            tmp=sc.nextInt();
            sum+=tmp;
            max = Math.max(max, tmp);
        }
        float avr = ((float) sum)/max*100/n;

        System.out.println(avr);

    }
}
