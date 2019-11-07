package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KakaoBlind2018_Zip {

    public static void main(String[] args) {

        String[] test = {"KAKAO", "TOBEORNOTTOBEORTOBEORNOT", "ABABABABABABABAB", "B"};

        for (String t : test) {
            System.out.println(Arrays.toString(solution(t)));
        }
    }

    public static int[] solution(String msg) {
        if (msg.length() == 0) {
            return new int[]{};
        } else if (msg.length() == 1) {
            return new int[]{msg.charAt(0) - 'A' + 1};
        }
        List<String> container = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        container.add("-");
        for (int i = 'A'; i <= 'Z'; i++) {
            container.add(Character.toString((char) i));
        }

        int i = 0;
        int j = 1;
        while (i < msg.length()) {
            if (!container.contains(msg.substring(i, j + 1))) {
                answer.add(container.indexOf(msg.substring(i, j)));
                container.add(msg.substring(i, j + 1));
                i = j;
                j++;
            } else {
                j++;
            }

            if (j == msg.length()) {
                if (container.contains(msg.substring(i, j))) {
                    answer.add(container.indexOf(msg.substring(i, j)));
                } else {
                    answer.add(container.indexOf(msg.substring(j - 1)));
                }
                break;
            }
        }

        int[] ans = new int[answer.size()];
        for (int k = 0; k < answer.size(); k++) {
            ans[k] = answer.get(k);
        }

        return ans;

    }
}
