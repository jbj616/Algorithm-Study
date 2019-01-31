import java.util.Scanner;

public class Baekjoon_1149 {
    static RGB[] rgb;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        rgb = new RGB[n];
        int[] minR = new int[n];
        int[] minG = new int[n];
        int[] minB = new int[n];

        for(int i=0; i<n; i++){
            rgb[i] = new RGB();
            rgb[i].setR(sc.nextInt());
            rgb[i].setG(sc.nextInt());
            rgb[i].setB(sc.nextInt());
        }
        minR[0] = rgb[0].r;
        minG[0] = rgb[0].g;
        minB[0] = rgb[0].b;

        for(int i=1; i<n; i++){
            minR[i] = Math.min(minB[i-1],minG[i-1])+rgb[i].r;
            minG[i] = Math.min(minB[i-1],minR[i-1])+rgb[i].g;
            minB[i] = Math.min(minR[i-1],minG[i-1])+rgb[i].b;
        }

        int min = Math.min(minR[n-1], minB[n-1]);
        min= Math.min(min, minG[n-1]);
        System.out.println(min);
    }

    public static int distance(RGB rgb){



        return 0;

    }
}
class RGB{
    int r;
    int g;
    int b;
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
