package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Baekjoon_1764 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] no_listener = new String[n];
        String[] no_shower = new String[m];
        List<String> no_both = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            no_listener[i] = sc.next();
        }
        for (int i = 0; i < m; i++) {
            no_shower[i] = sc.next();
        }

        Arrays.sort(no_shower);

        for (int i = 0; i < n; i++) {
            int tmp = Arrays.binarySearch(no_shower, no_listener[i]);

            if (tmp >= 0) {
                no_both.add(no_listener[i]);
            }
        }

        Collections.sort(no_both);
        System.out.println(no_both.size());
        for (String name : no_both) {
            System.out.println(name);
        }

    }

}
