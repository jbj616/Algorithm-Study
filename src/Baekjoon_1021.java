import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> dq = new LinkedList<>();
        int m = sc.nextInt();
        for (int i=1; i<=m; i++){
            dq.add(i);
        }
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i<n; i++){
            q.add(sc.nextInt());
        }

        while (!q.isEmpty()){
        }
    }
}
