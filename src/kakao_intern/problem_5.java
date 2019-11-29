package src.kakao_intern;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class problem_5 {

    public static void main(String[] args) {

        int[] test = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        System.out.println(solution(3, test));
    }

    public static int solution(int k, int[] stones) {
        SortedSet<Integer> hash = new TreeSet<>();
        for (int i = 0; i < stones.length; i++) {
            hash.add(stones[i]);
        }

        int height = hash.first();
        for (int i: hash){
            System.out.println(i);
            if (possible(k, stones, i)) {
                height = i;
            }else{
                return height;
            }
        }

        return height;
    }

    public static boolean possible(int k, int[] arr, int height) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < height) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                return false;
            }
        }

        return true;
    }

}
