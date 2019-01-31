import java.util.Scanner;

public class Baekjoon_10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int sum = 0;
        int[] num = new int[10];

        for(int i=0; i<str.length(); i++){
            sum+=str.charAt(i)-'0';
            num[str.charAt(i)-'0']++;
        }

        if(sum%3==0 && num[0]!=0){
            for(int i=9; i>=0; i--){
                for (int j=0; j<num[i]; j++)
                    System.out.print(i);
            }
        }else
            System.out.println("-1");
    }
}
