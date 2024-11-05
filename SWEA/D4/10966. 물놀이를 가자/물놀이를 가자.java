
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N, M;
	static char[][] map;
	static int[][] visited;
	static Queue<int[]> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N][M];
			visited = new int[N][M];
			q = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'W') {
						visited[i][j] = 0;
						q.offer(new int[] { i, j });
					} else {
						visited[i][j] = Integer.MAX_VALUE;
					}
				}
			}

			while (!q.isEmpty()) {
				int[] cur = q.poll();

				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];

					if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] != Integer.MAX_VALUE)
						continue;

					q.offer(new int[] { nr, nc });
					visited[nr][nc] = visited[cur[0]][cur[1]] + 1;

				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					ans += visited[i][j];
				}
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
