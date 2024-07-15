//
//  main.cpp
//  1018
//
//  Created by Yunji Choe on 2023/03/14.
//

#include <iostream>
using namespace std;

int main(int argc, const char * argv[]) {
    string str;
    cin >> str;
    int cnt = (int)str.size();
    for (int i = 1; i < str.size(); i++){
        if (str[i] == '='){
            cnt--;
            if (i > 1){
                if (str[i-1] == 'z' && str[i-2]=='d'){
                    cnt--;
                }
            }
        }
        
        else if (str[i] == 'j'){
            if (str[i-1] == 'l' || str[i-1] == 'n'){
                cnt--;
            }
        }
        
        else if (str[i] == '-'){
            cnt--;
        }
    }
    
    cout << cnt;
    return 0;
}
