
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1,0 };
	static int[] dc = { 0, -1, 0, 1 };
	static int finPic;
	static int picCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		finPic = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					finPic++;
				}
			}
		}
		System.out.println(finPic);
			if (finPic == 0) {
				System.out.println(0);
				return;
		}
		System.out.println(picCnt);

	}

	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		int[] v = { r, c };
		q.offer(v);
		visited[r][c] = true;
		int cntl = 1;

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];


				if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
					if (!visited[nr][nc] && map[nr][nc] == 1) {
						int[] next = { nr, nc };
						cntl++;
						q.offer(next);
						visited[nr][nc] = true;
					}
				}
			}

		}

		if (cntl > picCnt) {
			picCnt = cntl;
		}
		return;

	}

}
