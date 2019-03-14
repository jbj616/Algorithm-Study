import java.util.Scanner;

public class Baekjoon_2503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] baseball = new int[1000];
        int[] ball;

        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            int strikeCount = sc.nextInt();
            int ballCount = sc.nextInt();

            for (int j = 100; j < 1000; j++) {
                if (baseball[j] != -1) {
                    ball = new int[3];

                    ball[2] = j % 10; //첫번째 자리
                    ball[1] = j % 100 / 10; //두번째 자리
                    ball[0] = j / 100; //세번째 자리

                    if (ball[0] == 0 || ball[1] == 0 || ball[2] == 0) { //숫자가 0일때
                        baseball[j] = -1;
                        continue;
                    }

                    if (ball[0] == ball[1] || ball[1] == ball[2] || ball[0] == ball[2]) { //중복되는 숫자
                        baseball[j] = -1;
                        continue;
                    }

                    int tmpStrike = strikeCount;
                    int tmpBall = ballCount;

                    if (tmp / 100 == ball[0])
                        tmpStrike--;
                    else {
                        if (tmp % 100 / 10 == ball[0] || tmp % 10 == ball[0])
                            tmpBall--;
                    }
                    if (tmp % 100 / 10 == ball[1])
                        tmpStrike--;
                    else {
                        if (tmp / 100 == ball[1] || tmp % 10 == ball[1])
                            tmpBall--;
                    }
                    if (tmp % 10 == ball[2])
                        tmpStrike--;
                    else {
                        if (tmp / 100 == ball[2] || (tmp % 100 / 10) == ball[2])
                            tmpBall--;
                    }

                    if (tmpStrike != 0 || tmpBall != 0)
                        baseball[j] = -1;

                }
            }
        }
        int count = 0;
        for (int i = 100; i < 1000; i++) {
            if (baseball[i] != -1){
                count++;
            }

        }
        System.out.println(count);
    }
}
