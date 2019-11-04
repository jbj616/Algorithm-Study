package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2042 {

    static long[] num;
    static long[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        num = new long[N];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        tree = new long[N * 4];

        init(0, N-1, 1);
        //System.out.println(Arrays.toString(tree));

        for (int i=0; i<M+K; i++){
            int tmp = sc.nextInt();

            if(tmp ==1){
                int a = sc.nextInt()-1;
                long b = sc.nextLong();

                update(0, N-1, 1, a, b-num[a]);
                num[a] =b;
                //System.out.println("update : "+Arrays.toString(tree));
            }

            if(tmp ==2){
                int a = sc.nextInt()-1;
                int b = sc.nextInt()-1;

                System.out.println(sum(0, N-1, 1, a, b));
                //System.out.println(Arrays.toString(tree));
            }
            //System.out.println("tree : "+Arrays.toString(tree));
        }
    }

    public static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = num[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);

    }

    public static long sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);

    }

    public static void update(int start, int end, int node, int index, long dif){
        if( index< start || index >end) return ;
        tree[node] += dif;
        if(start==end) return;
        int mid = (start + end)/2;
        update(start, mid, node*2, index, dif);
        update(mid+1, end, node*2+1, index, dif);
    }

}
