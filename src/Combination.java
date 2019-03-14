public class Combination {
    public static void main(String[] args) {
       int[] arr = new int[5];
       Combi(arr, 0, 5, 2, 0);
    }
    public static void Combi(int[] arr, int index, int n, int r, int target){
        if( r== 0)Print(arr, index);
        else if(n == target){
            return;
        }else{
            arr[index] = target;
            Combi(arr, index+1, n, r-1, target+1);
            Combi(arr, index, n, r, target+1);
        }
    }
    public static void Print(int[] arr, int length){
        for (int i = 0;  i< length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }


}

