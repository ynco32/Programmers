
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int total;
	static int[] remain = { 0, 5, 5, 5, 5, 5 };
	static int ans = 0;
	static ArrayList<int[]> loc = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		total = 0;
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					total++;
					loc.add(new int[] { i, j });
				}
			}
		}

		color(0, 0, 0, total);

		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);

	}

	static void color(int r, int c, int cnt, int ones) {
		if (ones == 0) {
			ans = Math.min(ans, cnt);
			return;
		}

		if (r == 10 || c == 10) {
//			System.out.println("너냐?");
			return;
		}

		if (map[r][c] == 1) {

			for (int d = 5; d > 0; d--) {
				if (remain[d] > 0) {
					if (r + d <= 10 && c + d <= 10) {

						int check = 0;
						for (int i = r; i < r + d; i++) {
							for (int j = c; j < c + d; j++) {
								if (map[i][j] == 1)
									check++;
							}
						}

						if (check == d * d) {
							remain[d]--;
							for (int i = r; i < r + d; i++) {
								for (int j = c; j < c + d; j++) {
									map[i][j] = 0;
								}
							}

							if (cnt + 1 > ans) {
								remain[d]++;
								for (int i = r; i < r + d; i++) {
									for (int j = c; j < c + d; j++) {
										map[i][j] = 1;
									}
								}
								return;
							}

							color(r, c, cnt + 1, ones - d * d);

							remain[d]++;
							for (int i = r; i < r + d; i++) {
								for (int j = c; j < c + d; j++) {
									map[i][j] = 1;
								}
							}

						}

					}

				}

			}

		}

		else {
			boolean flag = true;
			for (int i = 0; i < loc.size(); i++) {
				int[] cur = loc.get(i);
				if (map[cur[0]][cur[1]] == 1) {
					color(cur[0], cur[1], cnt, ones);
					flag = false;
					break;
				}
			}

			if (flag)
				color(10, 10, cnt, ones);
		}
	}
}
