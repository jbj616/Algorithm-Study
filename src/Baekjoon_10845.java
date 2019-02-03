import java.util.Scanner;

public class Baekjoon_10845 {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        queue q = new queue();

        for (int i = 0; i < N; i++) {
            String tmp = sc.next();

            switch (tmp) {
                case "push":
                    q.push(sc.nextInt());
                    break;
                case "front":
                    System.out.println(q.front());
                    break;
                case "back":
                    System.out.println(q.back());
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    System.out.println(q.empty());
                    break;
                case "pop":
                    System.out.println(q.pop());
                    break;
            }
        }
    }
}

class queue {
    int front = 0;
    int rear = 0;
    int[] q = new int[10001];

    public void push(int a) {
        q[front++] = a;
    }

    public int pop() {
        if (empty() != 1)
            return q[rear++];
        else
            return -1;
    }

    public int size() {
        return front - rear;
    }

    public int empty() {
        if (front == rear)
            return 1;
        else
            return 0;
    }

    public int front() {
        if (empty() != 1)
            return q[rear];
        else
            return -1;
    }

    public int back() {
        if (empty() != 1)
            return q[front - 1];
        else
            return -1;
    }
}