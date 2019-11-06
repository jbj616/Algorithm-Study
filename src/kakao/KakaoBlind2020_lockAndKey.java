package kakao;

import java.util.ArrayList;
import java.util.List;

public class KakaoBlind2020_lockAndKey {

    public static void main(String[] args) {
        int[][] key = {{0, 1, 1}, {0, 0, 0}, {1, 0, 0}};

        int[][] lock = {{1, 1, 1, 1}, {1, 1, 0, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}};

        System.out.println(solution(key, lock));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        List<Pos> num = new ArrayList<>();
        //key 값 넣
        int size = key.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (key[i][j] == 1) {
                    num.add(new Pos(j, i));
                }
            }
        }

        int lockCount = count(lock);
        for (int k = 0; k < 4; k++) {
            num.forEach((x) -> x.rotate(key.length)); //회전

            for (int i = 1 - size; i < lock.length; i++) {
                for (int j = 1 - size; j < lock.length; j++) {
                    int count = 0;
                    boolean flag = false;
                    //체크
                    for (int a = 0; a < num.size(); a++) {
                        Pos tmp = num.get(a);
                        System.out.println(j + " " + (i));
                        if ((j + tmp.y) >= lock.length || (j + tmp.y) < 0 || (i + tmp.x) >= lock.length
                                || (i + tmp.x) < 0) {
                            continue;
                        }

                        if (lock[j + tmp.y][i + tmp.x] == 1) {
                            flag = true;
                        }

                        if (lock[j + tmp.y][i + tmp.x] == 0) {
                            count++;
                        }
                    }
                    if (count == lockCount && !flag) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static int count(int[][] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}

class Pos {

    int x;
    int y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void rotate(int size) {
        int tmp = y;
        this.y = x;
        this.x = size - tmp - 1;
    }
}