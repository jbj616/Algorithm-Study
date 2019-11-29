## Baekjoon_1010

```c++
#include <iostream>
using namespace std;

int main() {
    int t;

    cin >>t;

    for(int i=0 ; i<t; i++){
        int n, r;
        cin >> r >> n;

        int result =1 ;
        for(int i=r+1; i<=n; i++){
            result = result*i/(i-r); //조합공식 활용
        }
        cout<<result<<endl;
    }

    return 0;

}
```

