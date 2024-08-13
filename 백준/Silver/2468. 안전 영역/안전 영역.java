
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int N;
	static int[] cnts;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (max < map[i][j])
					max = map[i][j];
			}
		}
		int cnt;
		cnts = new int[max+1];
		for (int h = 0; h <= max; h++) {
			cnt = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > h) {
						cnt++;
						bfs(i, j, h);
					}
				}
			}
			cnts[h] = cnt;
		}

//		System.out.println(Arrays.toString(cnts));
		Arrays.sort(cnts);
		System.out.println(cnts[max]);
		

	}

	static void bfs(int r, int c, int h) {
		Queue<int[]> queue = new LinkedList<>();
		int[] temp = { r, c };
		queue.offer(temp);

		while (!queue.isEmpty()) {
			int[] q = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = q[0] + dr[d];
				int nc = q[1] + dc[d];

				if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
					if (map[nr][nc] > h && !visited[nr][nc]) {
						visited[nr][nc] = true;
						int[] newrc = { nr, nc };
						queue.offer(newrc);
					}
				}

			}

		}

	}
}
