import java.util.Scanner;

public class Baekjoon_1149 {
    static RGB[] rgb;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        rgb = new RGB[n];

        for(int i=0; i<n; i++){
            rgb[i].setR(sc.nextInt());
            rgb[i].setG(sc.nextInt());
            rgb[i].setB(sc.nextInt());
        }


    }
}
class RGB{
   private int r;
   private int g;
   private int b;
    public void setB(int b) {
        this.b = b;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setR(int r) {
        this.r = r;
    }
}
