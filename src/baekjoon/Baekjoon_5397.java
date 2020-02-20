package src.baekjoon;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon_5397 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(solution(sc.next()));
        }
    }

    public static String solution(String str) {
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);

            if (tmp == '<') {
                if (!left.isEmpty()) {
                    right.add(left.pop());
                }

            } else if (tmp == '>') {
                if (!right.isEmpty()) {
                    left.add(right.pop());
                }
            } else if (tmp == '-') {
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else {
                left.add(tmp);
            }

        }
        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) {
            right.add(left.pop());
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        return sb.toString();
    }

}
