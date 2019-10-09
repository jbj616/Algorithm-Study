import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_7453 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        int[] AB = new int[n * n];
        int[] CD = new int[n * n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
            C[i] = sc.nextInt();
            D[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[i * n + j] = A[i] + B[j];
                CD[i * n + j] = C[i] + D[j];
            }
        }

        Arrays.sort(CD);

        long result = 0;
        for (int i = 0; i < n*n; i++) {
            int left = lowerBound(CD, 0, n*n, -1*AB[i]);
            int right = upperBound(CD, 0, n*n, -1*AB[i]);

            result+=right - left;
        }
        System.out.println(result);
    }

    public static int upperBound(int arr[], int front, int rear, int key){
        int mid;
        while (front<rear){
            mid = (front+rear)/2;
            if(arr[mid]<=key)
                front = mid+1;
            else rear = mid;

        }
        return rear;
    }

    public static int lowerBound(int arr[], int front, int rear, int key){
        int mid;
        while (front < rear){
            mid = (front+rear)/2;
            if(arr[mid]<key){
                front = mid +1;
            }else{
                rear = mid;
            }
        }
        return rear;
    }
}
