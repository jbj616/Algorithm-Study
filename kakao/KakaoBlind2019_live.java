package kakao;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class KakaoBlind2019_live {

    public static void main(String[] args) {
        int[] test = {3, 1, 2};
        System.out.println(solution(test, 5));
    }

    public static int solution(int[] food_times, long k) {

        List<Food> foods = new LinkedList<>();

        for (int i = 0; i < food_times.length; i++) {
            foods.add(new Food(i + 1, food_times[i]));
        }

        foods.sort((x, y) -> x.remain - y.remain);

        int previous = 0;
        int i = 0;
        int length = food_times.length;
        for (Food f : foods) {
            long diff = f.remain - previous;
            if (diff != 0) {
                long spend = diff * length;
                if (spend > k) {
                    k %= length;
                    foods.subList(i, food_times.length).sort((x, y) -> x.locate - y.locate);
                    return foods.get(i + (int) k).locate;
                } else {
                    k -= spend;
                    previous = f.remain;
                }
            }
            i++;
            length--;
        }

        return -1;
    }
}

class Food {

    int locate;
    int remain;

    Food(int locate, int remain) {
        this.locate = locate;
        this.remain = remain;
    }


    @Override
    public String toString() {
        return locate + " " + remain;
    }
}