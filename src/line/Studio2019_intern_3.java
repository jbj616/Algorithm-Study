package src.line;

import java.util.Arrays;

public class Studio2019_intern_3 {

    public static void main(String[] args) {
        int[] test_1 = {1, 2, 1, 3, 1, 2, 1, 3};
        int[] test_2 = {1, 5, 0, 0, 0, 0, 0, 5, 6, 6};
        int[] test_3 = {1, 4, 3, 2, 1, 1, 0, 0};

        System.out.println(solution(test_1));

    }

    public static int solution(int[] arr) {
        int height = 0;
        for (int i = 0; i < arr.length; i++) {
            height = Math.max(height, arr[i]);
        }

        int[] water = Arrays.copyOf(arr, arr.length);
        System.out.println(height);

        for (int i = 0; i <= height; i++) {
            int first = findFisrtWall(arr, i);
            int last = findLastWall(arr, i);

            System.out.println(first + " " + last);
            if (first < last) {
                supplyWater(water, first, last, i);
            }
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += (water[i] - arr[i]);
        }

        return count;
    }

    public static void supplyWater(int[] water, int first, int last, int height) {
        for (int i = first; i <= last; i++) {
            if (water[i] < height) {
                water[i] = height;
            }
        }
        System.out.println("높이 = " + height + Arrays.toString(water));
    }

    public static int findFisrtWall(int[] arr, int height) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= height) {
                index = i;
            } else {
                if (index != -1) {
                    return index;
                }
            }
        }
        return index;
    }

    public static int findLastWall(int[] arr, int height) {
        int index = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= height) {
                index = i;
            } else {
                if (index != -1) {
                    return index;
                }
            }
        }
        return index;
    }

}
