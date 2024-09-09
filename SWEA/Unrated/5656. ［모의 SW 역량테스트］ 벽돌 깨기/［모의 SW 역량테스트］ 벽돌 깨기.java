
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, W, H, map[][], drop[], top[], ans, total;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			drop = new int[N];

			total = 0;

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0)
						total++;
				}
			}

			ans = total;
			perm(0);
//			System.out.println(total);
			System.out.println("#" + t + " " + ans);
		}
	}

	static void perm(int cnt) {

		if (cnt == N) {
			// 중복 순열 완성...

//			if (drop[0] == 2 && drop[1] == 2 && drop[2] == 6) {
//			System.out.println(Arrays.toString(drop));

			int[][] newMap = new int[H][W];
			int broken = 0;

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					newMap[i][j] = map[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				Queue<int[]> q = new LinkedList<>();
//					System.out.println(Arrays.deepToString(newMap));
				int topR = 0;

				for (int c = 0; c < W; c++) {
					ArrayList<Integer> blocks = new ArrayList<>();
					for (int r = H - 1; r >= 0; r--) {
						if (newMap[r][c] > 0) {
							blocks.add(newMap[r][c]);
							newMap[r][c] = 0;
						}
					}

					for (int k = 0; k < blocks.size(); k++) {
						newMap[H - 1 - k][c] = blocks.get(k);
					}

					if (c == drop[i])
						topR = H - blocks.size();
					if (topR == H)
						topR = H - 1;
				}

				q.offer(new int[] { topR, drop[i], newMap[topR][drop[i]] });
				while (!q.isEmpty()) {
					int[] current = q.poll();

					if (newMap[current[0]][current[1]] == 0) {
						continue;
					}

					broken++;
					newMap[current[0]][current[1]] = 0;

					// <<<
					for (int d = 1; d < current[2]; d++) {
						int nr = current[0];
						int nc = current[1] - d;

						if (nc < 0)
							break;
						int power = newMap[nr][nc];
						if (power == 0)
							continue;
						q.offer(new int[] { nr, nc, power });

					}

					// >>>
					for (int d = 1; d < current[2]; d++) {
						int nr = current[0];
						int nc = current[1] + d;

						if (nc >= W)
							break;

						int power = newMap[nr][nc];
						if (power == 0)
							continue;
						q.offer(new int[] { nr, nc, power });
					}

					// ^
					for (int d = 1; d < current[2]; d++) {
						int nr = current[0] - d;
						int nc = current[1];

						if (nr < 0)
							break;

						int power = newMap[nr][nc];
						if (power == 0)
							continue;
						q.offer(new int[] { nr, nc, power });

					}

					// V
					for (int d = 1; d < current[2]; d++) {
						int nr = current[0] + d;
						int nc = current[1];

						if (nr >= H)
							break;

						int power = newMap[nr][nc];
						if (power == 0)
							continue;
						q.offer(new int[] { nr, nc, power });
					}

				}
			}
//			System.out.println(broken);
			ans = Math.min(ans, total - broken);
//			}
			return;
		}

		for (int i = 0; i < W; i++) {
			drop[cnt] = i;
			perm(cnt + 1);
		}

	}
}
