import java.util.Scanner;

public class Baekjoon_14499 {
    static int N, M;
    static int[][] map;
    static int locationX, locationY;
    static int[] horizonDice = new int[4];
    static int[] verticalDice = new int[4];
    //주사위 vertical 0: 바닥 1:북 2:위 3:남 horizontal 0: 바닥 1: 동 2: 위 3: 서. 초기 바닥 6, 위 1, 동 3 서 4 남 5 북 2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        locationY = sc.nextInt(); //현재 위치
        locationX = sc.nextInt();
        map = new int[N][M];

        int k = sc.nextInt(); //횟수

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        map[locationY][locationX] =0; //주사위를 놓은 칸에 쓰여 있는 수는 항상 0

        Print();
        for (int i=0; i<k ;i++)
            moveDice(sc.nextInt());

    }
    static void Print(){
        if(map[locationY][locationX] ==0){
            //이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다.
            map[locationY][locationX] = horizonDice[0];
        }else{
            //0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
            horizonDice[0] = verticalDice[0] = map[locationY][locationX];
            map[locationY][locationX] =0;
        }
    }
    public static void moveDice(int a){ //주사위 이동
        if(a == 1){ //동
            if(locationX+1<M){
                locationX++;
                int tmp = horizonDice[0];

                horizonDice[0] = tmp; //큐 활용
                for (int i = 0; i<3; i++)
                    horizonDice[i] = horizonDice[i+1];
                horizonDice[3] = tmp;

                verticalDice[0] = horizonDice[0];
                verticalDice[2]= horizonDice[2];
                Print();
                System.out.println(horizonDice[2]);
            }
        }else if(a == 2){ //서
            if(locationX-1>=0){
                locationX--;
                int tmp = horizonDice[3];
                for (int i=3; i>0; i--)
                    horizonDice[i] = horizonDice[i-1];

                horizonDice[0] = tmp;

                verticalDice[0] = horizonDice[0];
                verticalDice[2]= horizonDice[2];
                Print();
                System.out.println(horizonDice[2]);
            }

        }else if( a== 3){ //북
            if (locationY - 1 >=0) {
                locationY--;
                int tmp = verticalDice[0];
                for (int i = 0; i<3; i++)
                    verticalDice[i] = verticalDice[i+1];
                verticalDice[3] = tmp;

                horizonDice[0] = verticalDice[0];
                horizonDice[2]= verticalDice[2];
                Print();
                System.out.println(horizonDice[2]);
            }

        }else if( a== 4){ //남
            if(locationY+1<N){
                locationY++;
                int tmp = verticalDice[3];
                for (int i=3; i>0; i--)
                    verticalDice[i] = verticalDice[i-1];
                verticalDice[0] = tmp;

                horizonDice[0] = verticalDice[0];
                horizonDice[2]= verticalDice[2];
                Print();
                System.out.println(horizonDice[2]);
            }
        }

    }
}
