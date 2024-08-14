
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] cheese;
	static int[][] cheeseInitial;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int h;
	static int lastH;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cheeseInitial = new int[N][M];
		cheese = new int[N][M];
		int cnt = 0;
		h = 0;
		int last = cnt;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheeseInitial[i][j] = Integer.parseInt(st.nextToken());
				if (cheeseInitial[i][j] == 1)
					cnt++;

			}
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				cheese[i][j] = cheeseInitial[i][j];
//			}
//		}

		while (cnt > 0) {
//			System.out.println();
			cheese = new int[N][M];
			lastH = h;
			if (h == 0)
				h = 2;
			else
				h++;

			for (int i = 0; i < N; i++) {
				if (cheeseInitial[i][0] == lastH) {
					bfs(i, 0);
				}
				if (cheeseInitial[i][M-1] == lastH) {
					bfs(i, 0);
				}
			}

			for (int j = 0; j < M; j++) {
				if (cheeseInitial[0][j] == lastH) {
					bfs(0, j);
				}
				if (cheeseInitial[N-1][j] == lastH) {
					bfs(0, j);
				}
			}
			/*------------------------------------------*/

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					cheese[i][j] = cheeseInitial[i][j];
//				}
//			}

			/*------------------------------------------*/
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cheeseInitial[i][j] == 1) {

						for (int d = 0; d < 4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];

							if (nr >= 0 && nc >= 0 && nr < N && nc < M && cheeseInitial[nr][nc] == h) {
								cheese[i][j] = h;
								break;
							}

						}
					}
				}
			}

//			System.out.println(Arrays.deepToString(cheeseInitial));
//			System.out.println(Arrays.deepToString(cheese));
			last = cnt;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cheese[i][j] == h) {
						cheeseInitial[i][j] = cheese[i][j];
						cnt--;
					} else {
						
					}
				}
			}
		}
		System.out.println(h-1);
		System.out.println(last);

	}

	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		int[] v = { r, c };
		q.offer(v);
		cheeseInitial[r][c] = h;

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];

				if (nr >= 0 && nc >= 0 && nr < N && nc < M && (cheeseInitial[nr][nc] == 0 || cheeseInitial[nr][nc] == lastH)) {
					cheeseInitial[nr][nc] = h;
					int[] add = { nr, nc };
					q.offer(add);
				}

			}

		}

	}

}
