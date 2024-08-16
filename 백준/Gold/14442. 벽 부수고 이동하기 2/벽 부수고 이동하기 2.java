
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int K;
	static int[][] map;
	static boolean[][][] visited;
	static ArrayList<Integer> cnts;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[K + 1][N][M];
		cnts = new ArrayList<>();

		if (N == 1 && M ==1) {
			System.out.println(1);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}

		for (int k = 0; k <= K; k++) {
			visited[k][0][0] = true;
		}

		bfs(0, 0, 0, 1);

		if (cnts.isEmpty())
			System.out.println(-1);
		else {
			cnts.sort(null);
			System.out.println(cnts.get(0));
		}

	}

	static void bfs(int r, int c, int k, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		int[] v = { r, c, k, cnt };
		q.offer(v);
		while (!q.isEmpty()) {
			int[] current = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];

				if (nr == N - 1 && nc == M - 1) {
					cnts.add(current[3]+1);
					return;
				}

				if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
					if (map[nr][nc] == 0 && !visited[current[2]][nr][nc]) {
						visited[current[2]][nr][nc] = true;
						q.offer(new int[] { nr, nc, current[2], current[3]+1 });
					} else if (map[nr][nc] == 1 && current[2] < K && !visited[current[2]+1][nr][nc]) {
						visited[current[2]+1][nr][nc] = true;
						q.offer(new int[] { nr, nc, current[2]+1, current[3]+1 });
					}
				}

			}

		}

	}

}
