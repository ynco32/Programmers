
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map, newMap, finMap;
	static int[] dir;
	static int N, M;
	static int total, ans;
	static ArrayList<int[]> cctvs = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
//		finMap = new int[N][M];

		total = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] > 0 && map[i][j] < 6)
					cctvs.add(new int[] { i, j });
			}
		}

		dir = new int[cctvs.size()];

		ans = Integer.MAX_VALUE;
		comb(0);
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(finMap[i]));
//		}
		System.out.println(ans);
	}

	static void comb(int cnt) {
		if (cnt == cctvs.size()) {
			newMap = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					newMap[i][j] = map[i][j];
				}
			}

			for (int i = 0; i < cctvs.size(); i++) {
				int[] cur = cctvs.get(i);
				cctvOn(newMap[cur[0]][cur[1]], cur[0], cur[1], i);
			}
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (newMap[i][j] == 0)
						count++;
				}
			}

//			if (ans > count) {
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < M; j++) {
//						finMap[i][j] = newMap[i][j];
//					}
//				}
//			}

			ans = Math.min(ans, count);

			return;
		}

		for (int i = 0; i < 4; i++) {
			dir[cnt] = i;
			comb(cnt + 1);
		}
	}

	static void cctvOn(int type, int r, int c, int d) {
		// ->
		if (type == 1) {
			monitor(dir[d], r, c);
		}

		else if (type == 2) {
			if (dir[d] == 0 || dir[d] == 2) {
				monitor(0, r, c);
				monitor(2, r, c);
			} else {
				monitor(1, r, c);
				monitor(3, r, c);
			}
		}

		else if (type == 3) {
			if (dir[d] == 0) {
				monitor(0, r, c);
				monitor(3, r, c);
			} else if (dir[d] == 1) {
				monitor(0, r, c);
				monitor(1, r, c);
			} else if (dir[d] == 2) {
				monitor(2, r, c);
				monitor(1, r, c);
			} else if (dir[d] == 3) {
				monitor(2, r, c);
				monitor(3, r, c);
			}
		} else if (type == 4) {
			if (dir[d] == 0) {
				monitor(0, r, c);
				monitor(2, r, c);
				monitor(3, r, c);
			} else if (dir[d] == 1) {
				monitor(0, r, c);
				monitor(3, r, c);
				monitor(1, r, c);
			} else if (dir[d] == 2) {
				monitor(2, r, c);
				monitor(0, r, c);
				monitor(1, r, c);
			} else if (dir[d] == 3) {
				monitor(2, r, c);
				monitor(3, r, c);
				monitor(1, r, c);
			}
		} else if (type == 5) {
			monitor(0, r, c);
			monitor(1, r, c);
			monitor(2, r, c);
			monitor(3, r, c);
		}

	}

	static void monitor(int dir, int r, int c) {
		// >>>>
		if (dir == 0) {
			c++;
			while (c < M && newMap[r][c] < 6) {
				if (newMap[r][c] == 0)
					newMap[r][c] = -1;
				c++;
			}
		}

		// V
		else if (dir == 1) {
			r++;
			while (r < N && newMap[r][c] < 6) {
				if (newMap[r][c] == 0)
					newMap[r][c] = -1;
				r++;
			}

		}

		// <<<
		else if (dir == 2) {
			c--;
			while (c >= 0 && newMap[r][c] < 6) {
				if (newMap[r][c] == 0)
					newMap[r][c] = -1;
				c--;
			}
		}

		// ^^^
		else if (dir == 3) {
			r--;
			while (r >= 0 && newMap[r][c] < 6) {
				if (newMap[r][c] == 0)
					newMap[r][c] = -1;
				r--;
			}
		}

	}

}
