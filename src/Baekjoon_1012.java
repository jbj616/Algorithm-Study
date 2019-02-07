import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_1012 {
    static int N,M, K;
    static boolean[][] isVisited;
    static Cabbage[][] cabbages;
    static int[] x = {1,0,-1,0};
    static int[] y = {0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int count;

        for(int i=0; i<t; i++){

            count = 0;
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();

            cabbages = new Cabbage[N][M];
            isVisited = new boolean[N][M];

            for(int j=0; j<N; j++){
                for(int k = 0; k<M; k++){
                    cabbages[j][k] = new Cabbage(k, j, 0);
                }
            }

            for(int j=0; j<K; j++){
                int a = sc.nextInt();
                int b= sc.nextInt();

                cabbages[a][b].value = 1;
            }

            for(int j=0; j<N; j++) {
                for (int k = 0; k < M; k++) {
                    if(isVisited[j][k] == false && cabbages[j][k].value ==1){
                        count++;
                        bfs(cabbages[j][k]);
                    }
                }
            }
//            for(int j=0; j<N; j++) {
//                for (int k = 0; k < M; k++) {
//                    System.out.print(cabbages[j][k].value+" ");
//                }
//                System.out.println();
//            }
            System.out.println(count);
        }

    }
    public static void bfs(Cabbage c){
        Queue<Cabbage> q = new LinkedList<>();
        q.offer(c);
        isVisited[c.y][c.x] = true;

        while (!q.isEmpty()){
            Cabbage tmp = q.poll();

            for(int i=0; i<4; i++){
                int c_x = x[i]+tmp.x;
                int c_y = y[i]+tmp.y;

                if(c_x>=0 && c_x <M && c_y>=0 && c_y<N){
                    if(!isVisited[c_y][c_x] && cabbages[c_y][c_x].value ==1){
                        isVisited[c_y][c_x] =true;
                        q.offer(cabbages[c_y][c_x]);
                    }
                }
            }
        }

    }
}
class Cabbage {
    int x, y;
    int value;

    Cabbage(int x, int y, int value)
    {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}