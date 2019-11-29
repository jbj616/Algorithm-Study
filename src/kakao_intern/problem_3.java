package src.kakao_intern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class problem_3 {

    public static void main(String[] args) {

        String[] test = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_Id = {"fr*d*", "abc1**"};

        String[] a = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] b = {"*rodo", "*rodo", "******"};

        String[] c = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] d = {"fr*d*", "*rodo", "******", "******"};

        System.out.println(solution(test, banned_Id));
        System.out.println(solution(a, b));
        System.out.println(solution(c, d));
    }

    public static int solution(String[] user_id, String[] banned_id) {
        List<String> ids = new ArrayList<>();
        List<Ban> banned = new ArrayList<>();
        for (int i = 0; i < user_id.length; i++) {
            ids.add(user_id[i]);
        }
        for (int i = 0; i < banned_id.length; i++) {
            banned.add(new Ban(banned_id[i]));
        }

        int count = 0;
        Iterator<String> iter = ids.iterator();
        while (iter.hasNext()) {
            String tmp = iter.next();

            for (int i = 0; i < banned.size(); i++) {
                if (isCorrect(tmp, banned.get(i).banName)) {
                    count++;
                    banned.get(i).list.add(tmp);
                }
            }
        }
        Queue<Integer>[] counter = new Queue[banned.size()];
        for (int i = 0; i < counter.length; i++) {
            counter[i] = new LinkedList<>();
        }

        int total = 1;
        int c = 0;
        for (int i = 0; i < banned.size(); i++) {
            if (banned.size() != 0) {
                c++;
                total *= banned.get(i).list.size();
            }
        }

        for (int i = 0; i < banned.size(); i++) {
            if (banned.get(i).list.size() != 0) {
                for (int j = 0; j < total / banned.get(i).list.size(); j++) {
                    for (int k=0; k<banned.get(i).list.size(); k++)
                        counter[i].add(k);

                }
            }
        }
        List<SortedSet<String>> m1 = new ArrayList<>();

        for (int k = 0; k < total; k++) {
            SortedSet<String> m = new TreeSet<>();
            for (int i = 0; i < banned.size(); i++) {

                if (banned.get(i).list.size() != 0) {
                    m.add(banned.get(i).list.get(counter[i].poll()));
                }
            }
            if (m.size() == c) {
                count++;
                System.out.println(m.toString());
                if(!m1.contains(m)){
                    m1.add(m);
                }
            }
        }

        System.out.println(count);


        return m1.size();
    }

    public static boolean isCorrect(String str, String banned) {
        if (str.length() != banned.length()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == banned.charAt(i)) {
                continue;
            }

            if (banned.charAt(i) == '*') {
                continue;
            }

            return false;
        }

        return true;
    }

}

class Ban {

    String banName;
    List<String> list;

    public Ban(String banName) {
        this.banName = banName;
        list = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "banName = " + list.toString();
    }
}
