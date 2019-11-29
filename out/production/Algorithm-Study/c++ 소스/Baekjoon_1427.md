```c++
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {

    vector<int> v;
    int n;

    cin >> n;

    while(n>0){
        v.push_back(n%10);
        n = n/10;
    }

    sort(v.begin(), v.end(), greater<int>());
    for(int j=0; j<v.size(); j++) {
        cout << v[j];
    }

    cout<< endl;
    return 0;
}
```

