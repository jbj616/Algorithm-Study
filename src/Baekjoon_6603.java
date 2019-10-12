import java.util.Scanner;

public class Baekjoon_6603 {

    static int[] num;
    static boolean[] isvisited;
    static int m = 6;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        while (true){
            int n = sc.nextInt();

            if(n == 0){
                break;
            }

            num  = new int[n];
            isvisited = new boolean[n];

            for (int i=0; i<n ;i++){
                num[i] = sc.nextInt();
            }

            DFS(0, 0);

            System.out.println();
        }

    }

    public static void DFS(int index, int depth){
        if(depth == m){
            for (int i=0; i<isvisited.length; i++){
                if(isvisited[i]){
                    System.out.print(num[i]+" ");
                }
            }
            System.out.println();
            return;
        }

        for (int i=index; i<num.length; i++){
            if(isvisited[i]){
                continue;
            }

            isvisited[i] = true;
            DFS(i, depth+1);
            isvisited[i] = false;
        }
    }
}
