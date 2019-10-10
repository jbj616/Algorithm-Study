import java.util.Scanner;

public class Baekjoon_14503 {

    static int[] c = {0, 1, 0, -1};
    static int[] r = {-1, 0, 1, 0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] room = new int[N + 2][M + 2];

        for (int i = 0; i < N + 2; i++) {
            room[i][0] = room[i][M + 1] = 1;
        }
        for (int i = 0; i < M + 2; i++) {
            room[0][i] = room[N + 1][i] = 1;
        }
        int count = 0;

        int location_r = sc.nextInt() + 1;
        int location_c = sc.nextInt() + 1;
        int direction = sc.nextInt();

        for (int i=1; i<=N; i++){
            for (int j=1; j<=M; j++){
                room[i][j] = sc.nextInt();
            }
        }

        int test = 0;

        while (true) {

            if (room[location_r][location_c] == 0) {
                room[location_r][location_c] = -1;
                count++;
            }

            direction = leftDircet(direction);
            int left_location_r = location_r + r[direction];
            int left_location_c = location_c + c[direction];
            test++;

            if (room[left_location_r][left_location_c] == 0) {
                test = 0;
                location_c = left_location_c;
                location_r = left_location_r;
            }

            if (test == 4) {
                int behind_direct = behindDirect(direction);
                int behind_location_r = location_r + r[behind_direct];
                int behind_location_c = location_c + c[behind_direct];

                if (room[behind_location_r][behind_location_c] == 1) {
                    break;
                } else {
                    test = 0;
                    location_r = behind_location_r;
                    location_c = behind_location_c;
                }
            }
        }

        System.out.println(count);


    }


    public static int leftDircet(int direction) {
        if (direction == 0) {
            return 3;
        }

        return direction - 1;
    }

    public static int behindDirect(int direction) {
        if (direction == 0) {
            return 2;
        }

        if (direction == 1) {
            return 3;
        }

        if (direction == 2) {
            return 0;
        }

        return 1;
    }
}
