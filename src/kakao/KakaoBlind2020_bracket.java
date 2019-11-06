package kakao;

import java.util.Arrays;
import java.util.Stack;

public class KakaoBlind2020_bracket {

    public static void main(String[] args) {
        String[] test = {"(()())()", ")(", "()))((()"};

        Arrays.stream(test).forEach((x) -> System.out.println(what(x)));
    }

    public static String solution(String p) {
        return what(p);
    }

    public static String what(String s) {
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 2) {
            return check(s, "");
        }

        for (int i = 2; i < s.length(); i += 2) {
            if (isBalance(s.substring(0, i))) {
                return check(s.substring(0, i), s.substring(i));
            }
        }
        return check(s, "");
    }


    public static String check(String u, String v) {
        if (isCorrect(u)) {
            return u + what(v);
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        stringBuffer.append(what(v));
        stringBuffer.append(')');

        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == ')') {
                stringBuffer.append('(');
            } else if (u.charAt(i) == '(') {
                stringBuffer.append(')');
            }
        }

        return stringBuffer.toString();

    }

    public static boolean isBalance(String s) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);

            if (tmp == '(') {
                left++;
            } else if (tmp == ')') {
                right++;
            }
        }

        return left == right;
    }

    public static boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);

            if (tmp == '(') {
                stack.add(tmp);
            } else if (tmp == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }
}
