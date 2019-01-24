import java.util.Scanner;

public class Baekjoon_2579 {
    static int one_walk;
    static int[] stairs;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        stairs = new int[n];

        for(int i=0; i<n; i++)
            stairs[i] = sc.nextInt();

        one_walk = 1;
        UpStair(0);
    }
    public  static int UpStair(int stair){
        int count = 0;

        if(one_walk==0 || one_walk==1){

        }else if(one_walk ==2){
            UpStair(stair+2);
        }
        UpStair(stair+1)

        return count;
    }
}
