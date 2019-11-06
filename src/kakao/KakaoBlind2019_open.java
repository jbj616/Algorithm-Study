package kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KakaoBlind2019_open {

    public static void main(String[] args) {
        String[] test = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
            "Change uid4567 Ryan"};

        System.out.println(Arrays.toString(record(test)));
    }

    public static String[] record(String[] record) {
        Queue<User> users = new LinkedList<>();
        HashMap<String, String> map = new HashMap<>();
        String id = "";

        for (int i = 0; i < record.length; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(record[i]);

            switch (stringTokenizer.nextToken()) {
                case "Enter":
                    id = stringTokenizer.nextToken();
                    map.put(id, stringTokenizer.nextToken());
                    users.add(new User(id, true));
                    continue;
                case "Leave":
                    users.add(new User(stringTokenizer.nextToken(), false));
                    continue;
                case "Change":
                    id = stringTokenizer.nextToken();
                    map.put(id, stringTokenizer.nextToken());
                    continue;
            }
        }
        int size = users.size();
        String[] answer = new String[size];
        for (int i = 0; i < size; i++) {
            User user = users.poll();
            if (user.enter) {
                answer[i] = map.get(user.id) + "님이 들어왔습니다.";
            } else {
                answer[i] = map.get(user.id) + "님이 나갔습니다.";
            }
        }

        return answer;

    }
}

class User {

    String id;
    boolean enter;

    public User(String id, boolean enter) {
        this.id = id;
        this.enter = enter;
    }

}