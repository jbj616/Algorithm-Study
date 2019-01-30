import java.util.Scanner;

public class Baekjoon_10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack st = new Stack();

        int n =sc.nextInt();
        for(int i=0; i<n; i++){
            String tmp = sc.next();

            if (tmp.equals("push")){
                int a = sc.nextInt();
                st.push(a);
            }else if(tmp.equals("top")){
                System.out.println(st.top());
            }else if(tmp.equals("pop")){
                System.out.println(st.pop());
            }else if(tmp.equals("empty")){
                System.out.println(st.isEmpty());
            }else if(tmp.equals("size")){
                System.out.println(st.size());
            }
        }

    }
}
class Stack{
    int top = -1;
    int[] stack = new int[1000000];
    public int isEmpty(){
        if(top == -1)
            return 1;
        else
            return 0;
    }
    public int top(){
        if(top == -1)
            return -1;
        else
            return stack[top];
    }
    public int push(int a){
        stack[++top] = a;
        return a;
    }
    public int pop(){
        if(top ==-1)
            return -1;
        else
            return stack[top--];
    }
    public int size(){
        return top+1;
    }
}
