import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_2960 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        int k = sc.nextInt();
        int[] num = new int[k+1];
        ArrayList<Integer> array = new ArrayList<>();

        for(int i= 2; i<=k; i++){
            if(num[i] !=-1){
                num[i] = 1; //소수
                array.add(i);

                for (int j = 2; ; j++) {
                    if (i * j <= k) {
                        if (num[i * j] != -1) {
                            num[i * j] = -1; //소수아님
                        }
                    } else
                        break;
                }
            }
        }

        for(int i=0; i<array.size(); i++){
            if(array.get(i)>=n && array.get(i)<=k)
                System.out.println(array.get(i));
        }
    }
}