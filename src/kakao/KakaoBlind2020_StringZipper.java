package kakao;

import java.util.Stack;

public class KakaoBlind2020_StringZipper {

    public static void main(String[] args) {
        String[] test = {"aabbaccc", "ababcdcdababcdcd", "abcabcdede", "abcabcabcabcdededededede", "xababcdcdababcdcd",
            "aaaaaaaaaa"};

        for (String s : test) {
            System.out.println(zipper(s));
        }
    }


    public static int zipper(String s) {
        int answer = s.length();

        Stack<String> q = new Stack<>();
        Stack<String> st = new Stack<>();
        int num = -1;

        for (int i = 1; i <= s.length() / 2; i++) {
            boolean flag = false;

            q.add(s.substring(0, i));
            num = 1;
            int index = i;
            while (index + i <= s.length()) {

                String tmp = s.substring(index, index + i);

                if (q.peek().equals(tmp)) {
                    flag = true;
                    index += i;
                    num++;
                } else {
                    if (flag) {
                        flag = false;
                        if(num!=1)
                            st.add(Integer.toString(num));
                    }
                    num=1;
                    q.add(tmp);
                    index += i;
                }
            }

            if (flag) {
                st.add(Integer.toString(num));
            }

            int sum = 0;
            while (!st.isEmpty()) {
                sum += st.pop().length();
            }
            answer = Math.min(i * q.size() + sum + (s.length() - index), answer);
            q = new Stack<>();


        }

        return answer;
    }

}
