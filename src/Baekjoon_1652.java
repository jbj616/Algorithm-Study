import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_1652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] map = new char[n][n];
        int horizon = 0;
        int vertical = 0;

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> horizonArray = new ArrayList<>();
            ArrayList<Integer> verticalArray = new ArrayList<>();
            horizonArray.add(-1);
            verticalArray.add(-1);

            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'X')
                    horizonArray.add(j);

                if (map[j][i] == 'X')
                    verticalArray.add(j);

            }

            horizonArray.add(n);
            verticalArray.add(n);

            for (int a = 1; a < horizonArray.size(); a++) {
                if (horizonArray.get(a) - horizonArray.get(a - 1) - 1 >= 2)
                    horizon++;
            }
            for (int a = 1; a < verticalArray.size(); a++) {
                if (verticalArray.get(a) - verticalArray.get(a - 1) - 1 >= 2)
                    vertical++;
            }
        }
        System.out.println(horizon);
        System.out.println(vertical);
    }

}
