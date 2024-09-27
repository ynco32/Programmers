
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int cnt = 2;
	static int[][] map;
	static int N;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					makeBridge(i, j);
				}
			}
		}

		System.out.println(ans);
	}

	private static void makeBridge(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c, 0 });
		boolean[][] visited = new boolean[N][N];
		visited[r][c] = true;


		while (!q.isEmpty()) {
			int[] current = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];
				int cnt = current[2] + 1;

				if (cnt > ans) return;
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;

				if (!visited[nr][nc] && map[nr][nc] == 0) {
					q.offer(new int[] { nr, nc, cnt });
					visited[nr][nc] = true;
				}
				
				else if (map[nr][nc] > 0 && map[nr][nc] != map[r][c]) {
					ans = Math.min(ans, cnt-1);
					return;
				}
				
			}

		}
	}

	private static void bfs(int r, int c) {
		map[r][c] = cnt;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] current = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;

				if (map[nr][nc] == 1) {
					map[nr][nc] = cnt;
					q.offer(new int[] { nr, nc });
				}
			}

		}
		cnt++;
	}
}
