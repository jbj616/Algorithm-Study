```c++
#include <iostream>
using namespace std;

int main() {
    int n, t;
    cin >> n >> t;

    cout <<"<";

    int c[n];
    for(int i=0; i<n; i++)
        c[i] = 0;

    int count = 0;
    int i=-1;
    int totalCount =0;
    while(totalCount<n-1){
        i =(i+1)%n;
        if(c[i]==0){
            count++;
        }
        if(count==t){
            cout << i+1 <<", ";
            totalCount++;
            count = 0;
            c[i] = 1;
        }
    }

    for(int i=0; i<n; i++){
        if(c[i] == 0){
            cout << i+1;
            break;
        }
    }

    cout << ">"<< endl;
}
```





> 다른 사람 풀이

```c++
#include <iostream>
#include <queue>

using namespace std;


int main() {

	int n,m;
	cin>>n>>m;

	queue<int> q;

	for(int i = 0; i <n; i++) 
		q.push(i+1);

	cout<<"<";
	while(!q.empty()) {

		for(int i = 0; i < m-1; i++) {
			int item = q.front();
			q.pop();
			q.push(item);
		}

		int item = q.front();
		q.pop();

		cout<<item;

		if(q.size() >= 1) 
			cout<<", ";
	}
	cout<<">"<<endl;
	return 0;
}
```

