package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_11403 {
    static int[][] graph;
    static boolean[] isVisited;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         N= sc.nextInt();
        graph = new int[N][N];

        for(int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                graph[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<N; i++){
            isVisited = new boolean[N];
            for (int j=0; j<N; j++){
                if(graph[i][j] == 1 && isVisited[j] == false){
                    bfs(i, j);
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static void bfs(int graph_x, int graph_y){
        isVisited[graph_y] = false;
        Queue<Integer> q = new LinkedList<>();
        q.offer(graph_y);

        while (!q.isEmpty()){
            int tmp = q.poll();

            for (int i=0; i<N; i++)
                if(isVisited[i]== false && graph[tmp][i] == 1){
                    q.offer(i);
                    graph[graph_x][i] =1;
                    isVisited[i] = true;
                }
        }
    }
}
