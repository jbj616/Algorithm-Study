import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Baekjoon_2910 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] counter = new int[c + 1];
        int[] location = new int[c + 1];
        for (int i=0; i<location.length; i++){
            location[i] = 9999;
        }
        List<NumberCount> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            location[tmp] = Math.min(location[tmp], i);
            list.add(new NumberCount(tmp, i));
            counter[tmp]++;
        }

        for (int i = 0; i < n; i++) {
            list.get(i).count = counter[list.get(i).num];
            list.get(i).location= location[list.get(i).num];
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {

            System.out.print(list.get(i).num+" ");
        }
    }
}

class NumberCount implements Comparable<NumberCount> {

    int num;
    int count;
    int location;

    NumberCount(int num, int location) {
        this.num = num;
        this.location = location;
    }

    @Override
    public int compareTo(NumberCount o) {
        if (count - o.count != 0) {
            return o.count - count;
        }
        return location - o.location;

    }
}