package baekjoon;

import java.util.*;

public class Baekjoon_1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] str = new String[n];
        int maxLen = 0;
        ArrayList<String> array = new ArrayList<>();
        Ascending ascending = new Ascending();

        for(int i=0; i< n; i++){
            str[i] = sc.next();
            if(maxLen < str[i].length())
                maxLen = str[i].length();
        }

        for(int i=1; i<=maxLen;i++){
            for (int j=0; j<str.length; j++){
                if(i == str[j].length()){
                   if(!array.contains(str[j]))
                       array.add(str[j]);
                }
            }
            Collections.sort(array, ascending);

            int size = array.size();
            for(int j=0; j<size; j++)
                System.out.println(array.remove(0));
        }
    }
}
class Ascending implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }

}
