package kakao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class KakaoBlind2018_NGame {



    public static void main(String[] args) {
        int[] n = {2, 16, 15, 8};
        int[] t = {4, 16, 1000, 4};
        int[] m = {2, 2, 2,  3};
        int[] p = {1, 1, 2, 3};

        for (int i = 0; i < 4; i++) {
            System.out.println(solution(n[i], t[i], m[i], p[i]));
        }
    }

    public static String solution(int n, int t, int m, int p) {
        int k = 1;
        int sum = 0;
        StringBuffer sb = new StringBuffer();
        while (true) {
            sum += k * Math.pow(n, k - 1);
            k++;
            if (sum > t * m) {
                System.out.println(k+"자리수");
                break;
            }
        }

        for (int i = 0; i <Math.pow(n,k-1); i++) {
            sb.append(Nth(i, n));
        }

        String num = sb.toString();
        sb = new StringBuffer();
        int i = p - 1;
        int count = 0;
        while (true) {
            sb.append(num.charAt(i));
            i += m;
            count++;
            if (count == t) {
                return sb.toString();
            }
        }
    }

    public static String Nth(int number, int n) {

        StringBuffer sb = new StringBuffer();
        while (true) {

            sb.append(Integer.toHexString(number % n).toUpperCase());
            number = number / n;
            if (number == 0) {
                return sb.reverse().toString();
            }
        }
    }

}
