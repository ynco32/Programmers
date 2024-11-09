
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class  Solution {

	static class Cell implements Comparable<Cell> {
		int r, c, x, cur;

		public Cell(int r, int c, int x, int cur) {
			super();
			this.r = r;
			this.c = c;
			this.x = x;
			this.cur = cur;
		}

		@Override
		public String toString() {
			return "Cell [r=" + r + ", c=" + c + ", x=" + x + ", cur=" + cur + "]";
		}

		@Override
		public int compareTo(Cell o) {
			return this.x - o.x;
		}

	}

	static int N, M, K;
	static int[][] map;
	static List<Cell> list = new ArrayList<>();
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			list.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N + K][M + K];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int c = Integer.parseInt(st.nextToken());

					if (c != 0) {
						list.add(new Cell(K / 2 + i, K / 2 + j, c, c + 1));
					}

					map[K / 2 + i][K / 2 + j] = c;

				}
			}

			for (int i = 1; i <= K; i++) {
				Collections.sort(list);

				for (int idx = list.size()-1; idx>=0; idx--) {
					Cell curCell = list.get(idx);
					if (curCell.cur - 1 + curCell.x == i) {
						list.remove(idx);
					}

					if (curCell.cur == i) {

						for (int d = 0; d < 4; d++) {

							int nr = curCell.r + dr[d];
							int nc = curCell.c + dc[d];

							if (map[nr][nc] == 0) {
								map[nr][nc] = curCell.x;
								list.add(new Cell(nr, nc, curCell.x, i + curCell.x + 1));
							}

						}
					}
				}

			}

			System.out.println("#" + t + " " + list.size());

		}

	}

}