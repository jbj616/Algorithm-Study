package baekjoon;

public class Baekjoon_4673 {
    public static void main(String[] args) {
       int[] selfNumber = new int[10001];

       for(int i=1; i<=10000; i++){
           int sum = i;
           int tmp = i;
           while (true){
             sum += tmp%10;
             tmp = tmp/10;
             if(tmp ==0) break;
           }
           if(sum <=10000)
            selfNumber[sum] =-1;
       }

       for(int i=1; i<=10000; i++){
           if(selfNumber[i]==0)
             System.out.println(i);
       }
    }
}
