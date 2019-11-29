package src.kakao;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class KakaoBlind2018_ther {

    public static void main(String[] args) {

        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String[] test = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String[] test2 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        System.out.println(solution("ABCDEFG", musicinfos));
        System.out.println(solution("CC#BCC#BCC#BCC#B", test));
        System.out.println(solution("ABC", test2));

    }

    public static String solution(String m, String[] musicinfos) {
        int max = -1;
        String answer = "(None)";

        for (int k = 0; k < musicinfos.length; k++) {
            StringTokenizer stringTokenizer = new StringTokenizer(musicinfos[k], ",");

            String[] start = stringTokenizer.nextToken().split(":");
            String[] finish = stringTokenizer.nextToken().split(":");

            int time;
            if (Integer.parseInt(finish[0]) * 60 - Integer.parseInt(start[0]) * 60 + Integer.parseInt(finish[1])
                    - Integer.parseInt(start[1]) + 1 < 0) {
                time = 24 * 60 - (Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]));
            } else {
                time =
                    Integer.parseInt(finish[0]) * 60 - Integer.parseInt(start[0]) * 60 + Integer.parseInt(finish[1])
                        - Integer.parseInt(start[1]);
            }

            String name = stringTokenizer.nextToken();
            String sheet = stringTokenizer.nextToken();

            if (sheet.contains("C#")){
                sheet.replaceAll("C#", "c");

            }

            if (sheet.contains("D#")){
                sheet.replaceAll("D#", "d");

            }
            if (sheet.contains("E#")){
                sheet.replaceAll("E#", "e");

            }

            if(time<sheet.length()){
                sheet = sheet.substring(0, time);
            }

            for (int i=0; i<m.length(); i++){

            }

        }

        return answer;
    }
//
//    public static Map<String, Integer> makeData(int time, String sheet) {
//        HashMap<String, Integer> map = new HashMap<>();
//        for (int i = 'A'; i <= 'G'; i++) {
//            map.put(Character.toString((char) i), 0);
//            map.put((char) i + "#", 0);
//        }
//        map.remove("B#");
//        map.remove("E#");
//
//        String sub;
//        for (int i = 0; i < sheet.length(); i++) {
//            if (time == 0) {
//                break;
//            }
//            if (i + 1 < sheet.length() && sheet.charAt(i + 1) == '#') {
//                sub = sheet.substring(i, i + 2);
//                if (!map.containsKey(sub)) {
//                    map.put(sub, 0);
//                }
//                i++;
//                time--;
//                continue;
//            }
//
//            sub = sheet.substring(i, i + 1);
//            if (!map.containsKey(sub)) {
//                map.put(sub, 0);
//            }
//            time--;
//        }
//
//        return map;
//    }
//
//    public static boolean check(String m, Map<String, Integer> map) {
//        for (int i = 0; i < m.length(); i++) {
//            if (i + 1 < m.length() && m.charAt(i + 1) == '#') {
//                if (map.containsKey(m.substring(i, i + 2))) {
//                    i++;
//                    continue;
//                } else {
//                    return false;
//                }
//            }
//
//            if (!map.containsKey(m.substring(i, i + 1))) {
//                return false;
//            }
//        }
//        return true;
//    }
}
