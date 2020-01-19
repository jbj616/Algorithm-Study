package src.line;

import java.util.Stack;

public class Studio2019_intern_4 {

    public static void main(String[] args) {
        int[] test_0 = {1, -1};
        int[] test_1 = {1, -1, 3};
        int[] test_2 = {4, 1, 3, 1};
        int[] test_3 = {5, 3, 1, -1, -1};
        int[] test_4 = {4, 4, 2, 4, -1, -1};
    }

    public static int solution(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        for (int i = 0; i < arr.length; i++) {
            move(stack, arr[i]);

            if (stack.peek() == 0) {
                return 0;
            }
        }

        return stack.peek();
    }

    public static void move(Stack<Integer> locate, int times) {

        if (times == -1) {
            int history = locate.pop();
            if (history == 0) {
                locate.add(0);

                return;
            }
        }

        if(locate.peek() >= 19){

        }

        if(locate.peek()>=20){

        }
    }
}
