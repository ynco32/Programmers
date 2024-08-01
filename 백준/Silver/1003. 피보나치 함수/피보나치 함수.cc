//
//  main.cpp
//  1003
//
//  Created by Yunji Choe on 2023/02/01.
//

#include <iostream>
using namespace std;


int dp[41];


int main(int argc, const char * argv[]) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;
    
    for (int i = 3; i < 41; i++){
        dp[i] = dp[i-1]+dp[i-2];
    }
    
    int t;
    cin >> t;
    while (t--){
        int num;
        cin >> num;
       
        if (num == 0){
            cout << 1 << " " << 0 << '\n';
        }
        else if (num == 0){
            cout << 0 << " " << 1 << '\n';
        }
        else {
            cout << dp[num-1] << " " << dp[num] << '\n';
        }
    }

    return 0;
}
