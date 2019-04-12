import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_9020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = new int[10001];
        ArrayList<Integer> prime = new ArrayList<>();

        for (int i=2; i<=10000; i++){
            if(num[i] == 0){
                prime.add(i);
                int j=2;
                while (true){
                    if (i*j>10000)
                        break;
                    num[i*j] = -1;
                    j++;

                }
            }
        }

        int t = sc.nextInt();
        int oho=0;
        for (int i=0; i<t; i++){
            int tmp = sc.nextInt();

            for (int j=0; j<prime.size(); j++){
                if(num[tmp-prime.get(j)] !=-1){

                    if(0 > tmp-2*prime.get(j)){
                        System.out.println(oho+" "+(tmp-oho));
                        break;
                    }oho = prime.get(j);
                }
            }

        }
    }
}
