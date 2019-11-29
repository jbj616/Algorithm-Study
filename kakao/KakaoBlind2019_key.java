package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class KakaoBlind2019_key {

    public static void main(String[] args) {

        String[][] test = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"},
            {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"},
            {"600", "apeach", "music", "2"}};

        System.out.println(solution(test));
    }

    public static int solution(String[][] relation) {


        return 1;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsetsHelper(list, new ArrayList<>(), nums, 0);
        return list;
    }

    public static void subsetsHelper(List<List<Integer>> list , List<Integer> resultList, int [] nums, int start){
        list.add(new ArrayList<>(resultList));
        for(int i = start; i < nums.length; i++){
            resultList.add(nums[i]);
            subsetsHelper(list, resultList, nums, i + 1);
            resultList.remove(resultList.size() - 1);
        }
    }
}
