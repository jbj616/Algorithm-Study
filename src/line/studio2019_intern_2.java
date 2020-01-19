package src.line;

import java.util.Stack;

public class studio2019_intern_2 {

    public static void main(String[] args) {
        String[] test = {"a1{abc}", "2{3{ab}2{d}}", "abcd", "abd2{ab}"};
        for (int i = 0; i < test.length; i++) {
            System.out.println(solution(test[i]));
        }


    }

    public static String solution(String str) {
        Stack<String> st = new Stack<String>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '}') {
                String str_tmp = "";
                while (!st.peek().equals("{")) {
                    str_tmp = st.pop().concat(str_tmp);
                }
                st.pop();

                int times = Integer.parseInt(st.pop());
                String sb2_tmp = "";
                for (int k = 0; k < times; k++) {
                    sb2_tmp = str_tmp.concat(sb2_tmp);
                }
                st.push(sb2_tmp);
            } else {
                st.push(Character.toString(str.charAt(i)));
            }
        }

        String answer = "";
        while (!st.isEmpty()) {
            answer = st.pop().concat(answer);
        }
        return answer;
    }

}