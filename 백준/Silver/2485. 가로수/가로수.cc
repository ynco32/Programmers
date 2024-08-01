#include <iostream>
using namespace std;

int gcd(int a, int b) {
    while (b != 0 ) {
        int temp = a % b;
        a = b;
        b = temp;
    }
        
    return a;
}

int main(int argc, const char * argv[]) {
    int tree[100000];
    int N;
    int cnt = 0;
    int dis = 0;
    int len = 0;
    
    cin >> N;
    cin >> tree[0];
    for (int i = 1; i < N; i++){
        cin >> tree[i];
        tree[i] = tree[i] - tree[0];
        
    }
    
    len = tree[N-1];

    dis = gcd(tree[1], tree[2]);
    for (int i = 3; i<N; i++){
        dis = gcd(tree[i], dis);
    }
    
    cnt = len / dis - N +1;
    cout << cnt;
    
    return 0;
}