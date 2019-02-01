import java.util.Scanner;

public class Baekjoon_9012 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            String tmp =sc.next();
            YesOrNo(tmp);
        }
    }
    public static void YesOrNo(String vps){
        int count = 0; //left :( right :)
        int result= 0;
        for(int i=0; i<vps.length(); i++){
            if(vps.charAt(i) == '('){
                count++;
            }else{
                count--;
                if(count<0)
                    result=-1;
            }
        }
        if(count != 0)
            result= -1;

        if(result ==-1)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}
