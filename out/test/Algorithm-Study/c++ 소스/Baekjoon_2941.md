```c++
#include <iostream>
#include <string>
using namespace std;

int main() {
    string str;
    cin >> str;

    int count =str.length();
    for(int i=0; i<str.length()-1; i++){
        if(str[i] == 'c'){
            if(str[i+1]== '=' | str[i+1]== '-'){
                count--;
            }
        }else if(str[i]== 'd'){
            if(str[i+1]== 'z' && i<str.length()-2&& str[i+2]== '=' ){
                count--;
                i++; //단어 중복 방지
                count--;
            }else if(str[i+1] =='-'){
                count--;
            }
        }else if(str[i] == 'l'){
            if(str[i+1] == 'j'){
                count--;
            }
        }else if(str[i] == 'n'){
            if(str[i+1] == 'j'){
                count--;
            }

        }else if(str[i]== 's'){
            if(str[i+1] == '='){
                count--;
            }

        }else if(str[i] == 'z'){
            if(str[i+1] == '='){
                count--;
            }
        }

    }
    cout << count<< endl;
}
```

