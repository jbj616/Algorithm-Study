> 문제 출처

https://www.acmicpc.net/problem/11052

> 풀이

dp[4]를 구할때 경우의 수

- card[4] + dp[0]
- card[3] + dp[1]
- card[2] + dp[2]
- card[1] + dp[3]

따라서 

```c++
for(int i=2; i<=n; i++)
        for(int j=1; j<=i;j++)
            dp[i] =max(dp[i], card[j]+dp[i-j]);
```

이 때 dp[0] = 0, dp[1] = card[1]



> 전체 소스

```c++
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n;

    cin >> n;
    int card[n+1];
    int dp[n+1];

        for(int i=1; i<n+1; i++){
            cin >> card[i];
        }

        for(int i=0; i<n+1; i++)
            dp[i] = 0;
    dp[1] = card[1];

    for(int i=2; i<=n; i++){
        for(int j=1; j<=i;j++){
            dp[i] =max(dp[i], card[j]+dp[i-j]);
        }
    }
    
    cout << dp[n]<< endl;

}
```

