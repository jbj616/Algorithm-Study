import java.util.Scanner;

public class Baekjoon_14503 {
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int[][] floor = new int[N][M];
        int robot_dir = 0, robot_left; //0: 북, 1: 동, 2: 서, 3: 남
        int location_X = 0, location_Y = 0;
        int[] dir_X = {0, 1, -1, 0};
        int[] dir_Y = {-1, 0, 0, 1};

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                floor[i][j] = sc.nextInt();

        while (true) {
            if (floor[location_Y][location_X] == 0) { //0 : 청소 x, 1: 벽, 2: 청소 한 곳
                floor[location_Y][location_X] = 2;
            } else {

                while (true) {
                    if (robot_dir != 0)
                        robot_left = (robot_dir - 1) % 4; //왼쪽
                    else
                        robot_left = 3;

                    int left_floor =floor[location_Y + dir_Y[robot_left]][location_X + dir_X[robot_left]];
                    if (left_floor == 0) {
                        robot_dir = robot_left;
                        location_X += dir_X[robot_left];
                        location_Y += dir_Y[robot_left];
                        continue;
                    } else if (left_floor == 1) {
                            robot_dir = robot_left;
                        continue;
                    }

                    if (floor[location_Y - 1][location_X] != 0 && floor[location_Y + 1][location_X] != 0 && floor[location_Y][location_X - 1] != 0
                            && floor[location_Y][location_X + 1] != 0) {
                        int back_floor = floor[location_Y+dir_Y[(robot_dir+2)%4]][location_X+dir_X[(robot_dir+2)%4]];
                        if (back_floor ==1) {
                            // 뒤 벽
                            break;
                        } else {
                            location_X += dir_X[(robot_dir+2)%4];
                            location_Y += dir_Y[(robot_dir+2)%4];
                        }
                    }
                }
            }
        }
    }
}
