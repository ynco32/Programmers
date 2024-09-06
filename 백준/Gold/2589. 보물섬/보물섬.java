import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		ans = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		
		}
		

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(ans);

	}

	static void bfs(int r, int c) {
		visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		int cnt = 0;
		visited[r][c] = true;
		q.offer(new int[] { r, c, 0 });
		while (!q.isEmpty()) {
			int[] current = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc])
					continue;

				if (map[nr][nc] == 'L') {
					visited[nr][nc] = true;
					q.offer(new int[] { nr, nc, current[2] + 1 });
					cnt = Math.max(cnt, current[2] + 1);
				}

			}

		}

		ans = Math.max(ans, cnt);
	}
}
