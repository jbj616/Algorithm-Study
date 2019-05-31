import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HW_04 {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        try {
            Scanner sc = new Scanner(new File("virus08.in"));
            int n = sc.nextInt();
            Queue<Integer> leftNode = new LinkedList<>();
            Queue<Integer> rightNode = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                leftNode.add(sc.nextInt());
                rightNode.add(sc.nextInt());
            }
            System.out.println(virus(leftNode, rightNode));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        System.out.println("걸린 시간: " + (System.currentTimeMillis() - time));
    }

    public static int virus(Queue<Integer> leftNode, Queue<Integer> rightNode) {
        int height = 1;
        int sub = 1;
        while (!leftNode.isEmpty()) {
            for (int i = 0; i < sub; i++) { // 높이단위록 검사
                int a = leftNode.poll();
                int b = rightNode.poll();

                if ((a == 0 && b != 0) || (b == 0 && a != 0)) {
                    return height;
                } else if (a == 0 && b == 0) {
                    return height;
                }
            }
            sub *= 2;
            height++;
        }
        return height;
    }
}
