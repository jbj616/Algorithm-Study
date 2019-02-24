import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Float> array = new ArrayList<>();
        String str = sc.next();
        boolean flag = false;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                flag = true;
                count++;
            } else if (str.charAt(i) == ')' && flag == true) {
                flag = false;
                sum+=--count;
            } else if (str.charAt(i) == ')') {
                flag = false;
                sum+=1;
                count--;
            }
        }

        System.out.println(sum);


    }
}
