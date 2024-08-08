

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int[][] map;
	static int[][] count;
	static int cnt = 1;
	static int N;
	static int M;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		count = new int [N][M];
		visited=new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		count[0][0] = 1;
		bfs(0,0);
		System.out.println(count[N-1][M-1]);
		
	}
	
	static int bfs(int x, int y) {
		Queue<Integer> queueX = new LinkedList<>();
		Queue<Integer> queueY = new LinkedList<>();
		queueX.offer(x);
		queueY.offer(y);
		visited[x][y] = true;

		
		while (!(queueX.isEmpty()||queueY.isEmpty())){
			int cx = queueX.poll();
			int cy = queueY.poll();
			int tempCnt = count[cx][cy];
			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				
				
				if (nx >= 0 && ny >= 0 && ny < M && nx < N) {
					if (!visited[nx][ny]) {
						count[nx][ny] = tempCnt+1;
						if (nx == N-1 && ny == M-1) {
							return cnt;
						}
						
						if (map[nx][ny] == 1) {
							visited[nx][ny] = true;
							
							queueX.offer(nx);
							queueY.offer(ny);
							
						}
					}
				}
				
				
			}
			
			
			
		}
		return cnt;
		
		
		
	}
}
