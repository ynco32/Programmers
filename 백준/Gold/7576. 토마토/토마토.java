
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int finDay = 1;
	static int cnt = 0;
	static int minus=0;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
//			System.out.println("???");
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) q.offer(new int[] {i,j});
				else if (map[i][j] == -1) minus++;
			}
		}
//		System.out.println(Arrays.deepToString(map));
//		
		finDay = bfs();
		
		if (cnt == N*M-minus) {
			if (finDay == 0) System.out.println(0);
			else
				System.out.println(finDay);
		}
		else System.out.println(-1);
		
	}
	
	static int bfs() {
		int day = 1;
		while (!q.isEmpty()) {
			int[] current = q.poll();
			cnt++;
//			int day;
			for (int d = 0; d < 4; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0) {
					day = map[current[0]][current[1]] + 1;
					map[nr][nc] = map[current[0]][current[1]] + 1;
					q.offer(new int[] {nr, nc});
				}
				
			}
			
			
		}
		
		return day-1;
	}
	
}
