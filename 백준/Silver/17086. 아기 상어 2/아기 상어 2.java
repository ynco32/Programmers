
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> cnts = new ArrayList<>();
	static int[] dr = { 1, 1, 1, -1, -1, -1, 0, 0};
	static int[] dc = { 0, 1, -1, 0, 1, -1, 1, -1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		ArrayList<int[]> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					visited = new boolean [N][M]; 
					bfs(i,j);
					
				}
			}
		}
		
		Collections.sort(cnts);
		System.out.println(cnts.get(cnts.size()-1));
		
	}

	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y, 0 });
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] current =	q.poll();
			
			for (int d = 0; d < 8; d++) {
				int nr = current[0]+ dr[d];
				int nc = current[1] + dc[d];
				int ncnt = current[2] + 1;
				
				
				if (nr >= 0 && nc >= 0&& nr < N && nc < M && !visited[nr][nc]) {
					if (map[nr][nc] == 1) {
						cnts.add(ncnt);
						return;
					}
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc, ncnt});
				}
				
				
			}
			
			
		}

	}
}
