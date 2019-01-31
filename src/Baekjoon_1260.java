import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_1260 {
    static int n;
    static Point[][] graph;
    static boolean[] isVisited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt()-1;

        graph = new Point[n][n];
        isVisited = new boolean[n];

        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                graph[i][j] = new Point(j,i, 0);

        for(int i=0; i<m; i++){
            int x = sc.nextInt()-1;
            int y =sc.nextInt()-1;
            graph[x][y].value = 1;
            graph[y][x].value = 1;
        }
        DFS(start);
        System.out.println();
        isVisited = new boolean[n];
        BFS(start);

    }
    public  static void DFS(int start){
        System.out.printf(start+1 +" ");
        isVisited[start] = true;

        for (int i=0; i<n; i++)
            if(!isVisited[i] && graph[start][i].value ==1)
                DFS(i);


    }
    public static void BFS(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited[start] = true;
        System.out.printf(start+1+" ");
        while (!q.isEmpty()){
            int tmp = q.poll();

            for(int i=0; i<n; i++){
                if(graph[tmp][i].value ==1 && !isVisited[i]){
                    isVisited[i] = true;
                    q.offer(i);
                    System.out.printf(i+1+" ");
                }
            }
        }
    }
}

class Point{
    int x, y;
    int value;

    Point(int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
