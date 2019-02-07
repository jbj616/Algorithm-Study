import java.util.Scanner;

public class Baekjoon_1193 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        long num = 1;
        long n = sc.nextInt();
        boolean flag = true;

        while(true){
            n = n-num;
            if(n<=0)
                break;
            num++;

            if(flag)
                flag = false;
            else
                flag = true;
        }

        if(flag)
            System.out.println(1+(-n)+"/"+(n+num));
        else {
            System.out.println((n + num) + "/" + (1 + (-n)));
        }
    }
}
