package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon_1874 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Queue<Integer> condition = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            condition.add(sc.nextInt());
        }

        System.out.println(makeResult(condition));

    }

    public static String makeResult(Queue<Integer> condition) {
        Stack<Integer> stack = new Stack<>();
        StringBuffer answer = new StringBuffer();
        int location = 0;

        while (true) {
            if (condition.size() == 0) {
                break;
            }

            int num = condition.poll();

            if (stack.empty()) {
                for (int i = location + 1; i <= num; i++) {
                    stack.push(i);
                    answer.append("+\n");
                }
                location = num;
                stack.pop();
                answer.append("-\n");
            } else {
                if (num > stack.peek()) {
                    for (int i = location + 1; i <= num; i++) {
                        stack.push(i);
                        answer.append("+\n");
                    }
                    location = num;
                    stack.pop();
                    answer.append("-\n");
                } else if (num < stack.peek()) {
                    return "NO";
                } else {
                    stack.pop();
                    answer.append("-\n");
                    continue;
                }
            }
        }

        return answer.toString();
    }

}
