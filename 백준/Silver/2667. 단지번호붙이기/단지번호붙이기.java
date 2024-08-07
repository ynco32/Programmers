

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int[][] house;
	static boolean[][] visited;
	static int N;
	static int cnt = 1;
	static StringBuilder sb = new StringBuilder();
	static int dx[] = {-1,1,0,0}; // 방향 체크 
	static int dy[] = {0,0,-1,1};
	static ArrayList arr = new ArrayList(); //개수 저장할 arr

	public static int dfs(int x, int y) {
		//방문한 좌표 체크 
		visited[x][y] = true;
		//4가지 방향으로 각각 탐색 
		for(int i = 0; i < 4; i++) {

			int new_x = x+dx[i];
			int new_y = y+dy[i];

			//하우스 범위 안에 있는지 체크 
			if(new_x >= 0 && new_y >= 0 && new_x < N && new_y < N) {
				if(house[new_x][new_y] == 1 && visited[new_x][new_y] == false){
					dfs(new_x, new_y);
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		house = new int[N][N];
		visited = new boolean[N][N];

		//집 위치 저장 
		for(int i = 0;i < N;i++){
			String input = sc.next();
			for(int j = 0;j < N; j++){ 
				house[i][j] = input.charAt(j)-'0';
			}
		}

		for(int i = 0; i < N;i++) {
			for(int j=0;j<N;j++)        
				if (house[i][j] == 1 && visited[i][j] == false) {
					cnt = 1;
					dfs(i,j);
					arr.add(cnt);
				}
		}
		
		//오름차순 정렬 
		Collections.sort(arr);

		System.out.println(arr.size());
		for(int i=0;i<arr.size();i++)
			System.out.println(arr.get(i));

	}


}
