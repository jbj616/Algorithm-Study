import java.util.*;

public class Baekjoon_2667 {
    static int N;
    static Map[][] maps;
    static boolean[][] isVisited;
    static int[] x = {1, 0, -1, 0};
    static int[] y = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        maps = new Map[N][N];
        isVisited = new boolean[N][N];
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                maps[i][j] = new Map(j, i, str.charAt(j) - '0');
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.printf(maps[i][j].value + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (isVisited[i][j] == false && maps[i][j].value == 1) {
                    array.add(bfs(maps[i][j]));
                }
            }
         Collections.sort(array);
        System.out.println(array.size());
         for(int i=0; i<array.size(); i++){
             System.out.println(array.get(i));
         }
    }

    public static int bfs(Map m) {
        int count = 1;
        Queue<Map> q = new LinkedList<>();
        q.offer(m);
        isVisited[m.y][m.x] = true;

        while (!q.isEmpty()) {
            Map tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int map_x = x[i] + tmp.x;
                int map_y = y[i] + tmp.y;

                if (map_x >= 0 && map_x < N && map_y >= 0 && map_y < N) {
                    if (isVisited[map_y][map_x] == false && maps[map_y][map_x].value == 1) {
                        isVisited[map_y][map_x] = true;
                        q.offer(maps[map_y][map_x]);
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

class Map {
    int x, y;
    int value;

    Map(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
