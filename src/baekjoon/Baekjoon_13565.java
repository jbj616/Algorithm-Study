package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_13565 {
    static int[] x = {-1,0,1,0}, y = {0,1,0,-1};
    static Laboratory[][] lab;
    static boolean[][] isVisited;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        lab = new Laboratory[N][M];
        isVisited = new boolean[N][M];

        for (int i=0; i<N; i++){
            String str = sc.next();
            for (int j = 0; j<M; j++){
                lab[i][j] = new Laboratory(j, i, str.charAt(j)-'0');
            }
        }

        for (int i=0; i<M; i++){
            if(lab[0][i].value == 0 && !isVisited[0][i]){
                bfs(lab[0][i]);
            }
        }

        boolean flag = false;

        for (int i=0; i<M; i++){
            if(lab[N-1][i].value == -1){
                flag = true;
                break;
            }
        }

        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
    public static void bfs(Laboratory l){
        Queue<Laboratory> q = new LinkedList<>();
        q.add(l);
        isVisited[l.y][l.x] = true;
        lab[l.y][l.x].value = -1;

        while (!q.isEmpty()){
            Laboratory tmp = q.poll();

            for (int i=0; i<4; i++){
                int lx = x[i] + tmp.x;
                int ly = y[i] + tmp.y;

                if(lx>=0 && ly >=0 && lx < M && ly <N){
                    if(!isVisited[ly][lx] && lab[ly][lx].value == 0){
                        q.add(lab[ly][lx]);
                        isVisited[ly][lx] = true;
                        lab[ly][lx].value = -1;
                    }
                }
            }
        }
    }
}

class Laboratory{
    int x, y;
    int value;

    Laboratory(int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
}