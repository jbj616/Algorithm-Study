package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Baekjoon_1946 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            int n = sc.nextInt();

            List<Worker> workers = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                workers.add(new Worker(sc.nextInt(), sc.nextInt()));
            }
            Collections.sort(workers);

            int flag = n + 1;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (flag > workers.get(j).online_test) {
                    count++;
                    flag = workers.get(j).online_test;
                }
            }
            System.out.println(count);
        }
    }
}

class Worker implements Comparable<Worker> {

    int offline_test;
    int online_test;

    public Worker(int offline_test, int online_test) {
        this.online_test = online_test;
        this.offline_test = offline_test;
    }

    @Override
    public int compareTo(Worker o) {
        return offline_test - o.offline_test;
    }
}