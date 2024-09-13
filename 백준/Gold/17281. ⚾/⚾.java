
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] score;
	static int[] store, field;
	static boolean[] visited;
	static int ans, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		score = new int[N][10];
		store = new int[10];
		field = new int[10];
		visited = new boolean[10];
		ans = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		store[4] = 1;
		visited[1] = true;
		perm(0);

		System.out.println(ans);
	}

	static void perm(int cnt) {
		if (cnt == 9) {
//			System.out.println(Arrays.toString(store));

			int inning = 0;
			int batter = 1;
			int out = 0;
			int tmpScore = 0;
			int test = 0;
			while (true) {
				int cur = score[inning][store[batter]];

				if (cur == 1 || cur == 2 || cur == 3) {
					for (int i = 1; i < 10; i++) {
						if (field[i] > 0) {
							field[i] += cur;
							if (field[i] > 3) {
								tmpScore++;
								field[i] = 0;
							}
						}
					}
					field[batter] = cur;
				}

				else if (cur == 4) {
					for (int i = 1; i < 10; i++) {
						if (field[i] > 0) {
							tmpScore++;
							field[i] = 0;
						}
					}
					tmpScore++;
				}

				else if (cur == 0) {
					out++;
					if (out == 3) {
						Arrays.fill(field, 0);
						inning++;
						out = 0;
						if (inning == N)
							break;
					}
				}

				batter++;
				if (batter == 10) {
					batter = 1;
				}
			}

//			if (ans < tmpScore) {
//				System.out.println(test);
//				System.out.println(Arrays.toString(store));
//			}
			
			ans = Math.max(ans, tmpScore);

			return;
		}

		if (cnt == 3)
			perm(cnt + 1);

		else {
			for (int i = 1; i < 10; i++) {
				if (!visited[i]) {
					visited[i] = true;
					store[cnt + 1] = i;
					perm(cnt + 1);
					visited[i] = false;
				}
			}
		}

	}
}
