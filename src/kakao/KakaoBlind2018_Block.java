package kakao;

import java.util.Stack;

public class KakaoBlind2018_Block {

    public static void main(String[] args) {
        String[] test1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        String[] test2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        System.out.println(block(4, 5, test1));
        System.out.println(block(6, 6, test2));

    }

    public static int block(int m, int n, String[] board) {
        int answer = 0;
        boolean[][] flag = new boolean[m][n];
        char[][] shapeBoard = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                shapeBoard[i][j] = board[i].charAt(j);
            }
        }
        int count = -1;
        while (true) {
            check(m, n, shapeBoard, flag);
            count = remove(n, m, shapeBoard, flag);
            if (count == 0) {
                break;
            }
            answer += count;
            flag = new boolean[m][n];

        }

        return answer;
    }

    public static void check(int m, int n, char[][] board, boolean[][] flag) {

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char shape = board[i][j];
                board[i][j] = shape;

                if (board[i][j] == '-') {
                    continue;
                }

                if (shape == board[i][j + 1] && shape == board[i + 1][j] && shape == board[i + 1][j + 1]) {
                    flag[i][j] = true;
                    flag[i + 1][j] = true;
                    flag[i + 1][j + 1] = true;
                    flag[i][j + 1] = true;

                } else {
                    continue;
                }
            }
        }
    }

    public static int remove(int n, int m, char[][] shape, boolean[][] flag) {
        int count = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (!flag[j][i]) {
                    stack.add(shape[j][i]);
                }else{
                    count++;
                }

                shape[j][i] = '-';
            }

            int index = m - 1;
            while (!stack.isEmpty()) {
                shape[index--][i] = stack.pop();
            }
        }

        return count;
    }
}
