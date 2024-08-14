
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean[][] visited;
	static int[][] mapNext;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		int year = 0;
		while (cnt < 2) {
			mapNext = new int[N][M];
			year++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int minus = 0;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];

						if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0) {
							minus++;
						}
					}
					mapNext[i][j] = map[i][j] - minus < 0 ? 0 : map[i][j] - minus;
				}
			}

			visited = new boolean[N][M];

			cnt = 0;
			int cntNone = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (mapNext[i][j] != 0 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
					else {
						cntNone++;
					}
				}
			}
			
			if (cntNone == N*M) {
				cnt=2;
				year=0;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = mapNext[i][j];
				}
			}

		}

		System.out.println(year);

	}

	static void bfs(int r, int c) {
		int[] v = { r, c };
		Queue<int[]> q = new LinkedList<>();
		q.offer(v);
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && mapNext[nr][nc] != 0 && !visited[nr][nc]) {
					int[] add = { nr, nc };
					q.offer(add);
					visited[nr][nc] = true;
				}

			}

		}

	};
}
