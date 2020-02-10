package src.summerorwiter;

import java.util.Arrays;

public class VisitLength {

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
    }

    public static int solution(String dirs) {
        int[][] map = new int[21][21];

        int locationX = 10;
        int locationY = 10;

        for (int i = 0; i < dirs.length(); i++) {
            if (dirs.charAt(i) == 'L') {
                if (locationX - 2 >= 0) {
                    map[locationY][locationX - 1] = 1;
                    locationX -= 2;
                }
            } else if (dirs.charAt(i) == 'R') {
                if (locationX + 2 <= 20) {
                    map[locationY][locationX + 1] = 1;
                    locationX += 2;
                }
            } else if (dirs.charAt(i) == 'U') {
                if (locationY - 2 >= 0) {
                    map[locationY - 1][locationX] = 1;
                    locationY -= 2;
                }
            } else {
                if (locationY + 2 < 21) {
                    map[locationY + 1][locationX] = 1;
                    locationY += 2;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
