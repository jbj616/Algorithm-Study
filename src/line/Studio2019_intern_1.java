package src.line;

import java.util.Arrays;

public class Studio2019_intern_1 {

    public static void main(String[] args) {
        int[] test_1 = {0,1,3,5,6,8,12,17};
        int[] test_2 = {0,1,2,3,4,8,9,11};
        System.out.println(solution(test_1));
    }

    public static boolean solution(int[] arr){

        System.out.println(hello(arr, 1, 1));

        return false;
    }

    public static boolean hello(int[] arr, int depth, int jump){
        System.out.println(Arrays.toString(arr) + " depth: "+depth+ " jump: "+jump);
        if(depth == arr.length-1){
            return true;
        }

        for (int i=depth+1; i<arr.length; i++){
            if(arr[i] - arr[depth] == jump-1){
                if(hello(arr, i, jump-1)){
                    return true;
                }
            }

            if(arr[i] - arr[depth] == jump){
                if(hello(arr, i, jump)){
                    return true;
                }
            }

            if(arr[i] - arr[depth] == jump+1){
                if(hello(arr, i, jump+1)){
                    return true;
                }
            }

            if(arr[i]-arr[depth]>jump+1){
                break;
            }
        }

        return false;
    }

}
