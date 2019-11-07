package kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KakaoBlind2019_live {

    public static void main(String[] args) {
        int[] test = {3, 1, 2};
        System.out.println(solution(test, 5));
    }

    public static int solution(int[] food_times, long k) {
        int size = food_times.length;

        int time = 0;

        for (long i = 0; i < k; ) {
            if (food_times[time] == 0) {
                time = (time + 1) % size;
            } else {
                food_times[time] -= 1;
                time = (time + 1) % size;
                i++;
            }
        }

        boolean flag = false;
        for (int i=0; i<food_times.length; i++){
            if(food_times[i] == 0){
                flag = true;
                break;
            }
        }

        if(false)
            return -1;
        return time+1;
    }
}
