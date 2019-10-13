import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Hack_02 {

    static int[] x = {1, 0, -1, 0};
    static int[] y = {0, 1, 0, -1};

    public static void main(String[] args) {
        String[] maps = {"A.B.C.D", ".B.C.D."};

        Graph graph = new Graph();
        int n = maps.length;
        int m = maps[0].length();
        Nations[][] nations = new Nations[n][m];
        boolean[][] isVisited = new boolean[n][m];
        Queue<Nations> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nations[i][j] = new Nations(j, i, maps[i].charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nations[i][j].value != '.' && !isVisited[i][j]) {

                    isVisited[i][j] = true;
                    q.add(nations[i][j]);

                    while (!q.isEmpty()) {
                        Nations tmp = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int move_x = tmp.x + x[k];
                            int move_y = tmp.y + y[k];

                            if (move_x >= 0 && move_y >= 0 && move_x < m && move_y < n) {

                                if (nations[move_y][move_x].value != '.' && !isVisited[move_y][move_x]) {
                                    isVisited[move_y][move_x] = true;
                                    if (nations[move_y][move_x].value != tmp.value) {
                                        System.out.println(tmp.value + "  :  " + nations[move_y][move_x].value);
                                        graph.put(tmp.value - 65, nations[move_y][move_x].value - 65);

                                    }

                                    q.add(nations[move_y][move_x]);
                                }
                            }
                        }
                    }

                }
            }
        }

        int[] answer = {0, 0};
        for (int i = 0; i < 26; i++) {
            int size = graph.getNode(i).size();
            answer[0] += size;
            answer[1] = Math.max(answer[1], size);
        }
        answer[0] = answer[0] / 2;
        System.out.println(answer[0] + " " + answer[1]);
    }


}

class Nations {

    int x;
    int y;
    char value;

    Nations(int x, int y, char value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}

class Graph {

    private List<Set<Integer>> graph;

    public Graph() {
        this.graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new HashSet<>());
        }
    }

    public Set<Integer> getNode(int x) {
        return this.graph.get(x);
    }

    public void put(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
}