```c++
#include <iostream>
#include <string>
using namespace std;

int main() {
    int t;
    cin >> t;

    string a,b;
    for(int i=0; i<t; i++){
        getline(cin, a, ',');
        getline(cin, b);

        cout << stoi(a)+stoi(b)<< endl;
    }
}
```

