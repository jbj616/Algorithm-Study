> 문제 출처

https://www.acmicpc.net/problem/9465



> 문제

상근이의 여동생 상냥이는 문방구에서 스티커 2n개를 구매했다. 스티커는 그림 (a)와 같이 2행 n열로 배치되어 있다. 상냥이는 스티커를 이용해 책상을 꾸미려고 한다.

상냥이가 구매한 스티커의 품질은 매우 좋지 않다. 스티커 한 장을 떼면, 그 스티커와 변을 공유하는 스티커는 모두 찢어져서 사용할 수 없게 된다. 즉, 뗀 스티커의 왼쪽, 오른쪽, 위, 아래에 있는 스티커는 사용할 수 없게 된다.

![img](https://www.acmicpc.net/upload/images/sticker.png)

모든 스티커를 붙일 수 없게된 상냥이는 각 스티커에 점수를 매기고, 점수의 합이 최대가 되게 스티커를 떼어내려고 한다. 먼저, 그림 (b)와 같이 각 스티커에 점수를 매겼다. 상냥이가 뗄 수 있는 스티커의 점수의 최댓값을 구하는 프로그램을 작성하시오. 즉, 2n개의 스티커 중에서 점수의 합이 최대가 되면서 서로 변을 공유 하지 않는 스티커 집합을 구해야 한다.

위의 그림의 경우에 점수가 50, 50, 100, 60인 스티커를 고르면, 점수는 260이 되고 이 것이 최대 점수이다. 가장 높은 점수를 가지는 두 스티커 (100과 70)은 변을 공유하기 때문에, 동시에 뗄 수 없다.

## 입력

첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫째 줄에는 n (1 ≤ n ≤ 100,000)이 주어진다. 다음 두 줄에는 n개의 정수가 주어지며, 각 정수는 그 위치에 해당하는 스티커의 점수이다. 연속하는 두 정수 사이에는 빈 칸이 하나 있다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다. 

## 출력

각 테스트 케이스 마다, 2n개의 스티커 중에서 두 변을 공유하지 않는 스티커 점수의 최댓값을 출력한다.



> 문제 풀이

|               | Sticker\[][1] | sticker\[][2] | sticker\[][3] | sticker\[][4] | sticker\[][5] |
| :-----------: | :-----------: | :-----------: | :-----------: | :-----------: | :-----------: |
| sticker\[0][] |    **50**     |      10       |    **100**    |      20       |      40       |
| sticker\[1][] |      30       |    **50**     |      70       |      10       |    **60**     |

- 같은 행에 있는 스티커가 연속으로 선택 될 수 없다. 0 -> 1 -> 0 행이거나 0 -> (공백) -> 1 행

- dp를 0과 1 두가지 행을 구분하여 구한다. (dp \[a][b]는 a행 b열을 반드시 포함한 b열까지의 합의 최댓값 )

  - 처음 초기 dp 설정 

  ```java
              dp[0][1] = sticker[0][1]; //50
              dp[1][1] = sticker[1][1]; //30
              dp[0][2] = sticker[1][1] + sticker[0][2]; //50 + 50
              dp[1][2] = sticker[0][1] + sticker[1][2]; //30 + 10
  ```

  - dp식 구성

  ```java
  for (int i = 3; i <= n; i++) { //0 -> 1 -> 0 행이거나 0 -> (공백) -> 1 행 중 최대
                  dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                  dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + sticker[1][i];
              }
  ```

- 출력

  ```java
  System.out.println(Math.max(dp[0][n], dp[1][n])); //0행과 1행 중 최댓값 출력
  ```

  

> 전체 소스

```java
import java.util.Scanner;

public class Baekjoon_9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();

            int[][] dp = new int[2][n + 1];
            int[][] sticker = new int[2][n + 1];

            for (int i = 1; i <= n; i++)
                sticker[0][i] = sc.nextInt();

            for (int i = 1; i <= n; i++)
                sticker[1][i] = sc.nextInt();
            //dp[1], dp[2] 설
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];
            dp[0][2] = sticker[1][1] + sticker[0][2];
            dp[1][2] = sticker[0][1] + sticker[1][2];


            for (int i = 3; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + sticker[1][i];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
```

