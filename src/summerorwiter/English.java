package src.summerorwiter;

import java.util.ArrayList;
import java.util.List;

public class English {

    public static void main(String[] args) {
        solution(3, new String[]{"tank","kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        solution(2, new String[]{"hello", "one", "even", "never", "now","world", "draw" });
    }

    public static int[] solution(int n, String[] words) {
        List<String> arr = new ArrayList<>();
        char flag = words[0].charAt(0);

        int i=0;
        int count=0;
        int times = 0;
        while (i < words.length){

            if(flag == words[i].charAt(0)){
                flag = words[i].charAt(words[i].length()-1);
            }else{
                return new int[]{count+1, times+1};
            }

            if(arr.contains(words[i])){
                return new int[]{count+1, times+1};
            }else{
                arr.add(words[i]);
            }

            count++;
            if(count == n){
                count = 0;
                times++;
            }
            i++;
        }

        return new int[]{0, 0};
    }

}
