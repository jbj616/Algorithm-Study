import java.util.*;

public class HW_01 {
    static ArrayList<Integer> prime;
    static int primeSize;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] num = new int[1001];
        num[1] = -1;
        prime = new ArrayList<>(); //소수

        //에라토스테네스의 체
        for (int i = 2; i <= 1000; i++) {
            if (num[i] != -1) { //소수일때
                prime.add(i);
                int a = 1;
                while (true) {
                    a++;
                    if (i * a >= 1000)
                        break;
                    num[i * a] = -1;
                }
            } else { //소수가 아닐때
                continue;
            }
        }
        primeSize = prime.size();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            Result(k);
        }
    }

    public static void Result(int k) {
        for (int a = 0; a < primeSize; a++) {
            if(k<prime.get(a)) //소수가 입력된 수 보다 클때
                break;

            for (int b = 0; b < primeSize; b++) {
                if(k<prime.get(b))
                    break;

                for (int c = 0; c < primeSize; c++) {
                    if(k<prime.get(c))
                        break;
                    //3개의 소수의 합이 입력된 정수와 일치 할 때
                    if (k == (prime.get(a) + prime.get(b) + prime.get(c))) {
                        System.out.println(prime.get(a) +" "+ prime.get(b) +" "+ prime.get(c));
                        return ;
                    }
                }
            }
        }
        System.out.println(0);
        return ;
    }
}
