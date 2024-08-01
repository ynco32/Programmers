//
//  main.cpp
//  2978
//
//  Created by Yunji Choe on 2022/05/30.
//

#include <iostream>
using namespace std;


int main(int argc, const char * argv[]) {
    int n, m;
    int card[100];
    cin >> n >> m;

    for (int i =0; i<n; i++){
        cin >> card[i];
    }
    int result = 0;
    for (int i = 0; i < n - 2; i++){
        for (int j = 1; j < n - 1; j++){
            for (int k = 3; k < n; k++){
                if (i != j && i != k && j != k){
                    int sum = card[i] + card[j] + card[k];
                    if (sum <= m && result < sum){
                        result = sum;
                    }
                }
            }
        }
    }
    
    
    cout << result << endl;
    return 0;
}
