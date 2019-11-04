package baekjoon;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon_8979 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Nation> nations = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            nations.add(new Nation(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(nations);

        int result = -1;

        for (int i = 0; i < nations.size(); i++) {
            if (nations.get(i).isNum(m)) {
                result = i;
                break;
            }
        }

        int count = 0;
        for (int i = result + 1; i < nations.size(); i++) {
            if (nations.get(result).equals(nations.get(i))) {
                count++;
            }else{
                break;
            }
        }

        System.out.println(nations.size()-result-count);
    }
}

class Nation implements Comparable<Nation> {

    private int num;
    private int gold;
    private int silver;
    private int bronze;

    public boolean isNum(int num) {
        return this.num == num;
    }

    public Nation(int num, int gold, int silver, int bronze) {
        this.num = num;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    public boolean equals(Nation nation) {
        return gold == nation.gold && silver == nation.silver && bronze == nation.bronze;
    }

    @Override
    public int compareTo(Nation nation) {
        if (gold - nation.gold != 0) {
            return gold - nation.gold;
        }

        if (silver - nation.silver != 0) {
            return silver - nation.silver;
        }

        return bronze - nation.bronze;
    }
}
