package kakao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class KakaoBlind2020_StringZipper {

    public static void main(String[] args) {
        String[] test = {"aabbaccc", "ababcdcdababcdcd", "abcabcdede", "abcabcabcabcdededededede", "xababcdcdababcdcd", "ababababababab"};

        for (String s : test) {
            System.out.println(zipper(s));
        }
    }


    public static int zipper(String s) {
        int answer = s.length();

        Stack<String> q = new Stack<>();

        for (int i = 1; i <= s.length()/2; i++) {
            boolean flag = false;

            int count = 0;
            q.add(s.substring(0, i));
            int index = i;
            while (index + i <= s.length()) {

                String tmp = s.substring(index, index + i);
                System.out.println(q.peek()+" " + tmp);
                if (q.peek().equals(tmp)) {
                    flag = true;
                    index += i;
                } else {
                    if (flag) {
                        count++;
                        flag = false;
                    }

                    q.add(tmp);
                    index += i;
                }
            }

            if (flag) {
                count++;
            }


            answer = Math.min(i * q.size() + count + (s.length() - index), answer);
            System.out.println(q.toString()+ " " + s.substring(index, s.length())+ " " + (i * q.size() + count + (s.length() - index)));
            q = new Stack<>();


        }

        return answer;
    }

}
