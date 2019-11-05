package kakao;

import java.util.*;

public class KakaoBlind2018_News {

    public static void main(String[] args) {

        String[] str1 = {"FRANCE", "handshake", "aa1+aa2", "E=M*C^2"};
        String[] str2 = {"french", "shake hands", "AAAA12", "e=m*c^2"};

        for (int i = 0; i < str1.length; i++) {
            System.out.println((int) J(str1[i], str2[i]));
        }
    }

    public static float J(String str1, String str2) {
        HashMap<String, Integer> array1 = splitStr(str1.toLowerCase());
        HashMap<String, Integer> array2 = splitStr(str2.toLowerCase());
        int count = 0;
        int total = 0;
        for (Map.Entry<String, Integer> entry : array1.entrySet()) {
            if (array2.containsKey(entry.getKey())) {
                if (array2.get(entry.getKey()) > entry.getValue()) {
                    count += entry.getValue();
                } else {
                    count += array2.get(entry.getKey());
                }
            }
            total += entry.getValue();
        }

        for (Map.Entry<String, Integer> entry : array2.entrySet()) {
            total += entry.getValue();
        }

        if (total == 0 && count == 0) {
            return 65536;
        }

        System.out.println("total = " + total + "count = " + count);
        total -= count;
        return (int) ((float) 65536 * count / total);
    }

    public static HashMap<String, Integer> splitStr(String str) {
        HashMap<String, Integer> hash = new HashMap<>();

        for (int i = 0; i < str.length() - 1; i++) {
            if (Character.isAlphabetic(str.charAt(i)) && Character.isAlphabetic(str.charAt(i + 1))) { //문자일때
                String tmp = str.substring(i, i + 2);
                if (hash.containsKey(tmp)) {
                    hash.put(tmp, hash.get(tmp) + 1);
                } else {
                    hash.put(tmp, 1);
                }
            }
        }
        return hash;
    }
}