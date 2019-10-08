import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2805 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] tree = new int[n + 1];

        tree[0] = 0;
        for (int i = 1; i < tree.length; i++) {
            tree[i] = sc.nextInt();
        }

        Arrays.sort(tree);

        int answer = -1;
        int index = -1;
        int tmp2 = -1;
        for (int i = tree.length - 1; i >= 0; i--) {
            tmp2 = 0;
            for (int j = i + 1; j < tree.length; j++) {
                tmp2 += (tree[j] - tree[i]);
            }

            if (tmp2 >= m) {
                answer = tree[i];
                index = i;
                break;
            }

        }

        if (tmp2 == m) {
            System.out.println(answer);
        } else {
            int tmp = 0;
            for (int i = tree[index+1] - tree[index]; i >0 ; i--) {
                tmp += tree.length - index;
                if (tmp2 + tmp == m) {
                    System.out.println(answer + i);
                    break;
                } else if (tmp2 + tmp > m) {
                    System.out.println(answer +i - 1);
                    break;
                }
            }
        }


    }

}
