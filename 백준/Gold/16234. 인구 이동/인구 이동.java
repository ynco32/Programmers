import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[][] visited;
	static int[][] map;
	static int N, L, R, num, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		num = 1;
		ans = 0;
		while (num <= N * N) {
			ans++;
			num = 1;
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == 0) {
						bfs(i, j, num);
						num++;
					}
				}
			}

//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println("==================================");
		}

		System.out.println(ans - 1);
	}

	static void bfs(int r, int c, int n) {
//		visited[r][c] = n;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });

		int sum = map[r][c];
		int count = 1;
		visited[r][c] = n;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] != 0)
					continue;

				int diff = Math.abs(map[cr][cc] - map[nr][nc]);
				if (diff >= L && diff <= R) {
					q.add(new int[] { nr, nc });
					visited[nr][nc] = n;
					sum += map[nr][nc];
					count++;
				}
			}

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == n) {
					map[i][j] = sum / count;
				}
			}
		}

	}
}
