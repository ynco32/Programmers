
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static int N;
	static int K;
	static int[][] map;
	static boolean[][] visited;
	static int cnt;
	static ArrayList<Integer> ans;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		ans = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int col1 = Integer.parseInt(st.nextToken());
			int row1 = Integer.parseInt(st.nextToken());
			int col2 = Integer.parseInt(st.nextToken());
			int row2 = Integer.parseInt(st.nextToken());

			for (int r = row1; r < row2; r++) {
				for (int c = col1; c < col2; c++) {
					map[r][c] = 1;
					visited[r][c] = true;
				}
			}
		}

		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 0) {
					cnt++;
					bfs(i, j, 1);
				}
			}
		}

		Collections.sort(ans);

		System.out.println(cnt);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		System.out.println();

	}

	static void bfs(int r, int c, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c, cnt });
		int wide = 1;

		while (!q.isEmpty()) {
			int[] current = q.poll();
			visited[current[0]][current[1]] = true;
			for (int d = 0; d < 4; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (!visited[nr][nc] && map[nr][nc] == 0) {
					wide++;
					q.offer(new int[] { nr, nc, current[2] + 1 });
					visited[nr][nc] = true;
				}

			}

		}

		ans.add(wide);
	}
}
