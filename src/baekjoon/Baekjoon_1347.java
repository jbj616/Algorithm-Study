package baekjoon;

import java.util.Scanner;

public class Baekjoon_1347 {
    static int dir = 0;
    static int[][] map;
    static int minX, minY, maxX, maxY;
    static int locationX, locationY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        map = new int[102][102];
        minX = minY = maxX = maxY = locationX = locationY =51;
        map[locationY][locationX] = 1; //현재 위치

        String move = sc.next();
        for (int i = 0; i < n; i++)
            Move(move.charAt(i));

        for (int j = minY; j <= maxY; j++) {
            for (int i = minX; i <= maxX; i++) {
                if (map[j][i] == 1)
                    System.out.print('.');
                else
                    System.out.print('#');
            }
            System.out.println();
        }
    }

    public static void Move(char m) {
        if (m == 'R') {
            dir = (dir + 1) % 4;
        }else if(m =='L'){
            if(dir !=0)
                dir = dir - 1;
            else
                dir = 3;
        }
        else {
            switch (dir) {
                case 0: //남
                    locationY++;
                    maxY = Math.max(maxY, locationY);
                    map[locationY][locationX] = 1;
                    break;
                case 1: //서
                    locationX--;
                    map[locationY][locationX] = 1;
                    minX = Math.min(minX, locationX);
                    break;
                case 2: //북
                    locationY--;
                    minY = Math.min(minY, locationY);
                    map[locationY][locationX] = 1;
                    break;
                case 3: //동
                    locationX++;
                    maxX = Math.max(maxX, locationX);
                    map[locationY][locationX] = 1;
                    break;
            }
        }
    }
}
