import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2490 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int[] array = new int[4];

        for(int i=0; i<3; i++){
            for(int j=0; j<4; j++){
                array[j] =sc.nextInt();
            }

            Arrays.sort(array);

            if(array[0] ==1)
                System.out.println("D");
            else if(array[1] ==1)
                System.out.println("A");
            else if(array[2] ==1)
                System.out.println("B");
            else if(array[3] ==1)
                System.out.println("C");
            else
                System.out.println("E");
        }
    }
}
