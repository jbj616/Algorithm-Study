package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_1113 {
    static int N;
    static int M;
    static int[] x = {-1, 0, 1, 0};
    static int[] y = {0, 1, 0, -1};
    static Pool[][] swimmingPool;
    static boolean[][] isVisited;
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);

        N = sc.nextInt();
        M= sc.nextInt();

        int max = 0;

        swimmingPool =new Pool[N][M];
        isVisited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = sc.next();
            for(int j=0; j<M; j++){
                swimmingPool[i][j] = new Pool(j, i, str.charAt(j)-'0');
            }
        }

        for(int i=1; i<N-1; i++){
            for(int j=1; j<M-1; j++){
                for (int k=2; k<=9; k++){
                    if(swimmingPool[i][j].value<=k){
                        isVisited = new boolean[N][M];
                        max= Math.max(max, bfs(swimmingPool[i][j], k));
                    }

                }
            }
        }

        System.out.println(max);

    }
    public static int bfs(Pool p, int num){
        Queue<Pool> q = new LinkedList<>();
        q.offer(p);
        isVisited[p.y][p.x] = true;
        //System.out.println("====");
       // System.out.println(p.x+" - "+p.y);
        int sum = num-p.value+1;

        while (!q.isEmpty()){
            Pool tmp = q.poll();

            for (int i=0; i<4; i++){
                int px = x[i]+tmp.x;
                int py = y[i]+tmp.y;

                if(px>=0 && py>=0 && px<M && py <= N){
                    if(swimmingPool[py][px].value <=num){
                        sum+=(num-swimmingPool[py][px].value+1);
                        isVisited[py][px]= true;
                       // System.out.println(num+" "+px+" "+ py+" sum="+sum);
                    }
                    if(px==0 || py==0 || px==M-1 || py ==N-1){
                        if(swimmingPool[py][px].value <=num){
                            return sum=-1;
                        }
                    }
                }
            }
        }

        return sum;

    }
}
class Pool{
    int x, y;
    int value;
    Pool(int x, int y, int value){
        this.y = y;
        this.x = x;
        this.value = value;
    }
}
