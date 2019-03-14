
import java.util.Scanner;

public class Baekjoon_1952 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int garo = scanner.nextInt();
        int sero = scanner.nextInt();
        int full = garo*sero;
        int index = 0;
        int sum = garo;
        while(sum != full){
            if(index%2 ==0){
                sum += --sero;
                index ++;
            }
            else if(index %2 ==1){
                sum += --garo;
                index++;
            }
        }
        System.out.println(index);
    }
}
