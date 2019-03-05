import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int num = 0;

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=n; i++){
            q.offer(i);
        }

        while (!q.isEmpty()){

        }
        System.out.println(num);
    }
}
