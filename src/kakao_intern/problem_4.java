package src.kakao_intern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem_4 {

    static int test = 10000000;

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(10, new long[]{1, 3, 4, 1, 3, 1})));
        System.out.println(Arrays.toString(solution(1000000004, new long[]{1000000002, 10000000, 10000000, 10000000, 1000000004, 1000000004})));
    }

    public static long[] solution(long k, long[] room_number) {
        long[] answer;
        List<Long> locate = new ArrayList<>();

        if (k < test) {
            boolean[] flag = new boolean[(int) k];
            for (long number : room_number) {
                int tmp = (int) number - 1;
                while (flag[tmp]) {
                    tmp++;

                    if (tmp == k) {
                        tmp = 0;
                    }
                }

                flag[tmp] = true;

                locate.add((long) tmp + 1);
            }

        } else {

            boolean[][] flag = new boolean[(int) (k / test) + 1][test];

            for (long number : room_number) {
                int i = (int) (number / test) ;
                int j = (int) (number % test) ;


                while (flag[i][j]) {
                    if (j == test-1) {
                        i++;
                        j++;
                    }
                    j++;


                }

                System.out.println(i+" "+j);
                flag[i][j] = true;
                locate.add((long) (i) * test+ j);

            }

        }

        System.out.println(locate.toString());
        answer = new long[locate.size()];
        for (int i = 0; i < locate.size(); i++) {
            answer[i] = locate.get(i);
        }
        return answer;
    }
}
