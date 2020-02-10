package src.summerorwiter;

import java.util.Arrays;

public class Origami {

    public static void main(String[] args) {

        for (int i = 1; i <= 4; i++) {
            solution(i);
        }

    }

    public static int[] solution(int n) {
        int[] arr = new int[(int) Math.pow(2, n) - 1];

        int middle = (arr.length - 1) / 2;
        arr[middle] = 0;
        slice(arr, 0, arr.length - 1, middle);

        return arr;

    }

    public static void slice(int[] arr, int first, int last, int middle) {
        if (first == middle || last == middle) {
            return;
        }

        if(last-first+1 == 3){
            arr[last] = 1;
            arr[first] = 0;
            return;
        }
        int left = (first + middle - 1) / 2;
        arr[left] = 0;
        slice(arr, first, middle - 1, (first + middle - 1) / 2);

        int right = (middle + 1 + last) / 2;
        arr[right] = 1;
        slice(arr, middle + 1, last, (middle + 1 + last) / 2);

    }

}
