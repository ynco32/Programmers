#include <iostream>
using namespace std;
bool check[42] = {false, };

int main(int argc, const char * argv[]) {
    int num, re;
    int cnt = 0;
   
    for (int i = 0; i < 10; i++){
        num = 0;
        re = 0;
        cin >> num;
        re = num % 42;
        if (check[re] == false) check[re] = true;
    }
    
    for (int i = 0; i < 42; i++){
        if (check[i] == true) cnt++;
    }
    
    cout << cnt;
    
    return 0;
}
