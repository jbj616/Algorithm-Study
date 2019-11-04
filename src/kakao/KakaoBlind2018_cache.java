package kakao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KakaoBlind2018_cache {

    private final static int MISS = 5;
    private final static int HIT = 1;

    public static void main(String[] args) {

        String[] test1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(solution(3, test1));
    }

    public static int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0) {
            return cities.length * MISS;
        }

        int answer = 0;
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {

            String city = cities[i].toUpperCase();

            if (queue.contains(city)) {

                queue.remove(city);
                queue.add(city);

                answer += HIT;
                continue;
            }

            if (queue.size() < cacheSize) {
                queue.add(city);
            } else {
                queue.poll();
                queue.add(city);
            }

            answer += MISS;

        }

        return answer;
    }
}
