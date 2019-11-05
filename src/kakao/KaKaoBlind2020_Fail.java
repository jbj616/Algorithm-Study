package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KaKaoBlind2020_Fail {

    public static void main(String[] args) {
        int[] test1 = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] test2 = {4, 4, 4, 4, 4};

        System.out.println(Arrays.toString(fail(5, test1)));

        System.out.println(Arrays.toString(fail(4, test2)));

    }

    public static int[] fail(int N, int[] stages) {
        List<Test> answer = new ArrayList<>();
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            answer.add(new Test(i + 1));
        }

        Arrays.sort(stages);
        int count = 0;

        for (int i = 1; i <= N; i++) {
            int upper = upper(stages, 0, stages.length, i);
            int lower = lowerBound(stages, 0, stages.length, i);

            count = upper - lower;
            if (count == 0) {
                answer.get(i - 1).value = 0;
            } else {
                answer.get(i - 1).value = (double) (count) / (stages.length - lower);
            }
        }

        Collections.sort(answer);

        return ans;

    }

    public static int upper(int arr[], int front, int rear, int key) {
        int mid;

        while (front < rear) {
            mid = (front + rear) / 2;
            if (arr[mid] <= key) {
                front = mid + 1;
            } else {
                rear = mid;
            }
        }

        return rear;
    }

    public static int lowerBound(int arr[], int front, int rear, int key) {
        int mid;

        while (front < rear) {
            mid = (front + rear) / 2;
            if (arr[mid] < key) {
                front = mid + 1;
            } else {
                rear = mid;
            }
        }

        return rear;
    }
}

class Test implements Comparable<Test> {

    int stage;
    double value;

    Test(int i) {
        this.stage = i;
    }

    @Override
    public int compareTo(Test o) {
        double tmp = o.value - this.value;
        if (tmp == 0) {
            return this.stage - o.stage;
        } else if (tmp > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
