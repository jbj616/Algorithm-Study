package kakao;

import java.util.Arrays;
import sun.text.normalizer.Trie;

public class KakaoBlind2020_lyrics {

    public static void main(String[] args) {
        String[] test = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] query = {"fro??", "fr???", "fro???", "pro?", "????o"};
        System.out.println(Arrays.toString(solution(test, query)));
    }

    public static int[] solution(String[] words, String[] queries) {

        Trie d = new Trie() {
            @Override
            protected int getSurrogateOffset(char c, char c1) {
                return 0;
            }

            @Override
            protected int getValue(int i) {
                return 0;
            }

            @Override
            protected int getInitialValue() {
                return 0;
            }
        }
        int[] answer = new int[queries.length];
        Arrays.sort(words);

        String[] order = Arrays.copyOf(words, words.length);

        String[] reverseOrder = Arrays.copyOf(words, words.length);
        for (int i = 0; i < reverseOrder.length; i++) {
            reverseOrder[i] = new StringBuffer(reverseOrder[i]).reverse().toString();
        }
        Arrays.sort(reverseOrder);

        for (int k = 0; k < queries.length; k++) {
            int count = 0;
            if (queries[k].charAt(0) == '?') {

                String tmp2 = new StringBuffer(queries[k]).reverse().toString();
                int lower = -(Arrays.binarySearch(reverseOrder, tmp2) + 1);
                int upper = -(Arrays.binarySearch(reverseOrder, tmp2.replace("\\?", "~")) + 1);
                for (int i = lower; i < upper; i++) {

                    if (tmp2.length() == reverseOrder[i].length()) {
                        int tmp = tmp2.indexOf("?");
                        if (tmp2.substring(0, tmp).equals(reverseOrder[i].substring(0, tmp))) {
                            count++;
                        }
                    }
                }
            } else {
                int lower = -(Arrays.binarySearch(order, queries[k]) + 1);
                int upper = -(Arrays.binarySearch(order, queries[k].replace("\\?", "~")) + 1);

                for (int i = lower; i < upper; i++) {

                    if (queries[k].length() == order[i].length()) {

                        int tmp = queries[k].indexOf("?");
                        if (queries[k].substring(0, tmp).equals(order[i].substring(0, tmp))) {
                            count++;
                        }
                    }
                }


            }
            answer[k] = count;
        }

        return answer;
    }

}
