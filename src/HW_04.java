import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HW_04 {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        try{
            Scanner sc = new Scanner(new File("virus02.in"));
            int n = sc.nextInt();
            Queue<Integer> leftQ = new LinkedList<>();
            Queue<Integer> rightQ = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                leftQ.add(sc.nextInt());
                rightQ.add(sc.nextInt());
            }
            System.out.println(virus(n,leftQ, rightQ));
        }catch (FileNotFoundException e){
            System.out.println(e);
        }

        System.out.println("걸린 시간: " + (System.currentTimeMillis()-time));

    }

    public static int virus(int n, Queue<Integer> leftQ, Queue<Integer> rightQ) {
        int height = 1;
        int sub = 1;
        for (int k=0; k<n;k++){
            for (int i = 0; i < sub; i++) {
                int a = leftQ.poll();
                int b = rightQ.poll();

                if ((a == 0 && b != 0) || (b == 0 && a != 0)) {
                    return height ;
                } else if (a == 0 && b == 0) {
                    return height-1;
                }
            }
            height++;
            sub *= 2;
        }
        System.out.println("---");
        return height ;
    }
}
