public class hack_1 {

    public static void main(String[] args) {
        int[] exam = {3, 2, 3, 6, 4, 5};
        int[] exam1 = {2,1,3};
        int[] exam2 = {1,2,3};

        System.out.println(result(exam1));
        System.out.println(result(exam2));
        System.out.println(result(exam));
    }

    public static int result(int[] arr){
        int result = 0;

        for (int i=0; i<arr.length-2; i++){
            if(arr[i]>arr[i+1]){
                result+= arr[i]-arr[i+1];
            }
        }

        return result;
    }

}
