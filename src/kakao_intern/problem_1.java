package src.kakao_intern;

import java.util.Stack;

public class problem_1 {

    public static void main(String[] args) {

        int[][] test = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] move = {1, 5, 3, 5, 1, 2, 1, 4};

        solution(test, move);

    }

    public static int solution(int[][] board, int[] moves) {


        Stack<Integer> bag = new Stack<>();
        int count = 0;

        for (int i = 0; i < moves.length; i++) {
            int element = top(board, moves[i] - 1);

            if(element == -1){
                continue;
            }

            if(bag.isEmpty()){
                bag.add(element);
            }else{
                if(bag.peek() == element){
                    bag.pop();

                    count+=2;
                }else{
                    bag.add(element);
                }
            }

        }

        return count;
    }

    public static int top(int[][] board, int index) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][index] != 0) {
                int tmp = board[i][index];
                board[i][index] = 0;

                return tmp;
            }
        }

        return -1;
    }
}
