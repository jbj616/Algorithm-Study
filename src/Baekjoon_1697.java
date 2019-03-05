
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_1697 {
    static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        isVisited = new boolean[100001];

        System.out.println(bfs(n, k));
    }

    public static int bfs(int n, int k) {
        Queue<Integer> q = new LinkedList();

        int count = 0;
        q.offer(n);
        isVisited[n] = true;

        while (true) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int tmp = q.poll();

                if (tmp == k) {
                    return count;
                }

                if (tmp + 1 <= 100000 ) {
                    if(!isVisited[tmp + 1]){
                        q.offer(tmp + 1);
                        isVisited[tmp + 1] = true;
                    }
                }

                if (tmp - 1 >= 0) {
                    if(!isVisited[tmp - 1]){
                        q.offer(tmp - 1);
                        isVisited[tmp - 1] = true;
                    }
                }

                if (2 * tmp <= 100000) {
                    if(!isVisited[2 * tmp]){
                        q.offer(2 * tmp);
                        isVisited[tmp - 1] = true;
                    }
                }
            }
            count++;
        }
    }
}
