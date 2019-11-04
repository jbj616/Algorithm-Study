package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_9466 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> array = new ArrayList<>();
        int t = sc.nextInt();
        for (int j=0; j<t; j++) {
            int n = sc.nextInt();
            int num = 0;
            Stack st = new Stack();
            int[] student = new int[100001];
            int[] count = new int[100001];
            for (int i = 1; i <= n; i++) {
                student[i] = sc.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                count[student[i]] += 1;
            }
            for (int i = 1; i <= n; i++) {
                if (count[i] == 0) {
                    st.push(i);
                }
            }
            while (st.size()!=0) {
                int k = st.pop();
                count[student[k]] -= 1;
                if (count[student[k]] == 0) {
                    st.push(student[k]);
                }
            }
            for (int i = 1; i <= n; i++) {
                if (count[i] == 0) {
                    num++;
                }
            }
            System.out.println(num);
        }
    }
}
