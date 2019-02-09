import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] virus = new int[n + 1][n + 1];
        boolean[] isVisited = new boolean[n + 1];
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            virus[x][y] = 1;
            virus[y][x] = 1;
        }

        Queue<Integer> q = new LinkedList<>();


        isVisited[1] = true;
        q.offer(1);
        while (!q.isEmpty()) {
            int tmp = q.poll();

            for (int j = 1; j <= n; j++) {
                if (virus[tmp][j] == 1 && !isVisited[j]) {
                    isVisited[j] = true;
                    q.offer(j);
                }
            }
        }
        int count=-1;
    for(int i=0; i<isVisited.length; i++){
        if(isVisited[i] == true)
            count++;
    }
        System.out.println(count);
    }
}
