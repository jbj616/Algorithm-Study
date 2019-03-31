
import java.util.*;

public class Baekjoon_4485 {
    static PriorityQueue<Node> pg;
    static int[][] map;
    static int n;
    static int[] x = {1, 0, -1, 0};
    static int[] y = {0, -1, 0, 1};
    static int distance[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int index = 1;
        while (true) {
            n = sc.nextInt();

            if(n==0)
                break;

            map = new int[n][n];
            distance = new int[n][n];
            pg = new PriorityQueue<>();
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    map[i][j] = sc.nextInt();
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
            distance[0][0] =  0;
            pg.add(new Node(0,0,map[0][0]));

            dijkstra();
            System.out.println("Problem " + (index++)+": "+distance[n-1][n-1]);
        }
    }
    public static void dijkstra(){
        while (!pg.isEmpty()){
            Node tmp = pg.poll();

            for (int i=0; i<4; i++){
                int dx = x[i] + tmp.x;
                int dy = y[i] + tmp.y;

                if(dx>=0 && dy >=0 && dx < n && dy <n){
                    if(distance[dy][dx] > tmp.dis +map[dy][dx]){
                        distance[dy][dx] = tmp.dis + map[dy][dx];
                        pg.add(new Node(dx, dy, distance[dy][dx]));
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int value;
    int dis;
    int x, y;

    Node(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }

    @Override
    public int compareTo(Node o) {
        return this.dis <= o.dis ? -1 : 1;
    }
}