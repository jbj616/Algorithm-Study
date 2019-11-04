package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String input;

        Stack<Character> st = new Stack<>();
        Stack<Character> st_tmp = new Stack();

        for (int i=0; i< str.length(); i++){
            st.push(str.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            input = br.readLine();
            if (input.charAt(0) == 'L') {
                if(!st.empty())
                    st_tmp.push(st.pop());
            } else if (input.charAt(0) == 'D') {
                if(!st_tmp.isEmpty()){
                    st.push(st_tmp.pop());
                }
            } else if (input.charAt(0)== 'B') {
                if(!st.isEmpty()){
                    st.pop();
                }
            } else if (input.charAt(0) == 'P')
                st.push(input.charAt(2));
        }

        while (!st.isEmpty()){
            st_tmp.push(st.pop());
        }
        while (!st_tmp.isEmpty()){
            System.out.print(st_tmp.pop());
        }
        System.out.println();
    }
}
