package src.kakao_intern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class problem_2 {

    public static void main(String[] args) {
        String[] test = {"{{2},{2,1},{2,1,3},{2,1,3,4}}", "{{1,2,3},{2,1},{1,2,4,3},{2}}", "{{20,111},{111}}",
            "{{123}}", "{{4,2,3},{3},{2,3,4,1},{2,3}}"};

        System.out.println(test[0]);
        for (int i = 0; i < test.length; i++) {
            System.out.println(Arrays.toString(solution(test[i])));
        }

    }

//    public static int[] solution(String s) {
//        int[] answer;
//
//        List<Integer> list = new ArrayList<>();
//        s = s.replaceAll("},\\{", "-");
//        s = s.replaceAll("\\{\\{", "");
//        s = s.replaceAll("\\}\\}", "");
//        System.out.println("=="+s);
//        StringTokenizer stringTokenizer = new StringTokenizer(s, "-");
//
//        while (stringTokenizer.hasMoreTokens()){
//            String[] splited = stringTokenizer.nextToken().split(",");
//
//            for (int i=0; i<splited.length; i++){
//                if(list.contains(Integer.parseInt(splited[i]))){
//                    continue;
//                }
//                list.add(Integer.parseInt(splited[i]));
//            }
//        }
//
//        System.out.println(list.toString());
//        answer = new int[list.size()];
//        for (int i = 0; i< list.size(); i++){
//            answer[i] = list.get(i);
//        }
//        return answer;
//    }

    public static int[] solution(String s) {
        String[] split = s.substring(2, s.length() - 2).split("},\\{");

        for (int i = 1; i < split.length; i++) {
            split[i] = split[i];
        }

        List<List<Integer>> data = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(split[i], ",");
            List<Integer> tmp = new LinkedList<>();
            while (stringTokenizer.hasMoreTokens()) {
                tmp.add(Integer.parseInt(stringTokenizer.nextToken()));
            }
            Collections.sort(tmp);
            data.add(tmp);
        }


        int size = 1;
        List<Integer> answer = new ArrayList<>();
        while (true) {
            if(size > data.size()){
                break;
            }
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).size() == size) {
                    for (int j = 0; j < data.get(i).size(); j++) {
                        int tmp = data.get(i).get(j);
                        if (!(answer.contains(tmp))) {
                            answer.add(tmp);
                        }
                    }
                }
            }
            size++;
        }

        int[] ans = new int[answer.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = answer.get(i);
        }

        return ans;
    }
}
//String newString = s.substring(2, s.length() - 2);
//        String[] strings = newString.split("},");
//
//        for (int i = 1; i < strings.length; i++) {
//            strings[i] = strings[i].substring(1);
//        }
//
//        ArrayList<ArrayList> maps = new ArrayList<>();
//        for (int i = 0; i < strings.length; i++) {
//            String[] intStrings = strings[i].split(",");
//            int[] array = new int[intStrings.length];
//            for (int j = 0; j < array.length; j++) {
//                array[j] = Integer.parseInt(intStrings[j]);
//            }
//            ArrayList<Integer> map = new ArrayList<>();
//            for (int j = 0; j < array.length; j++) {
//                map.add(array[j]);
//            }
//            maps.add(map);
//        }
//
//        for (int i = 0; i < maps.size(); i++) {
//            Collections.sort(maps.get(i));
//        }
//        int size = 1;
//        ArrayList<Integer> answerList = new ArrayList<>();
//        while (size <= maps.size()) {
//            for (int i = 0; i < maps.size(); i++) {
//                if (maps.get(i).size() == size) {
//                    for (int j = 0; j < maps.get(i).size(); j++) { //
//                        if (!(answerList.contains(maps.get(i).get(j)))) {
//                            answerList.add((int) maps.get(i).get(j));
//                        }
//                    }
//                }
//            }
//            size++;
//
//        }
//        int[] answer = new int[answerList.size()];
//        for (int i = 0; i < answer.length; i++) {
//            answer[i] = answerList.get(i);
//        }