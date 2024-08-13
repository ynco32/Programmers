#include<bits/stdc++.h>
using namespace std;
int board[102][102][102];
int dist[102][102][102];
queue<pair<pair<int,int>,int>> q; // 3개의 입력값을 넣기 위해 pair안에 pair를 만든다.
int dx[6] = {1,0,-1,0,0,0};  // 같은 층의 상하좌우 + 윗층 아래층
int dy[6] = {0,1,0,-1,0,0};
int dz[6] = {0,0,0,0,1,-1};
int m, n, h;
void bfs(){
	while(!q.empty()){
		int a = q.front().first.first;
		int b = q.front().first.second;
		int c = q.front().second;
		q.pop();
		for(int i = 0; i < 6; i++){
			int nx = a + dx[i];
			int ny = b + dy[i];
			int nz = c + dz[i];
			if(nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h) continue;
			if(dist[nx][ny][nz] >= 0) continue; // dist가 -1일 경우만 밑에 코드가 실행
			q.push(make_pair(make_pair(nx,ny),nz));
			dist[nx][ny][nz] = dist[a][b][c] + 1;
		}
	}
}
int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> m >> n >> h;
	for(int k = 0; k < h; k++){
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				cin >> board[i][j][k];
				if(board[i][j][k] == 1){ // 토마토가 있다면 큐에 넣음
					q.push(make_pair(make_pair(i,j),k));
				}
				if(board[i][j][k] == 0){ // 토마토가 없다면 dist = -1로 설정
					dist[i][j][k] = -1;
				}
			}
		}
	}
	bfs();
	int ans = 0;
	for(int k = 0; k < h; k++){ // 전체를 돌면서 최대 dist 값을 구한다.
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(dist[i][j][k] == -1){ // 안익은 토마토가 있다면 -1을 반환하고 종료
					cout << "-1\n";
					return 0;
				}
				ans = max(dist[i][j][k], ans);
			}
		}
	}
	cout << ans << '\n';
	return 0;
}