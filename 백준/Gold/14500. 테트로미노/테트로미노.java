
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 2][M + 2];

		for (int j = 0; j < M + 2; j++) {
			map[0][j] = Integer.MIN_VALUE;
			map[N + 1][j] = Integer.MIN_VALUE;
		}

		for (int i = 1; i < N + 1; i++) {
			map[i][0] = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j < M + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
			map[i][M + 1] = Integer.MIN_VALUE;
		}

		int max = Integer.MIN_VALUE;

		for (int r = 1; r < N + 1; r++) {
			for (int c = 1; c < M + 1; c++) {

				if (r + 3 <= N + 1) {
					int sum = 0;
					int one = Math.max(map[r - 1][c], map[r + 3][c]);
					for (int i = 0; i < 3; i++) {
						sum += map[r + i][c];
						int temp = Math.max(map[r + i][c - 1], map[r + i][c + 1]);
						one = Math.max(one, temp);
					}
					sum += one;
					max = Math.max(sum, max);

				}

				if (c + 3 <= M + 1) {
					int sum = 0;
					int one = Math.max(map[r][c - 1], map[r][c + 3]);
					for (int i = 0; i < 3; i++) {
						sum += map[r][c + i];
						int temp = Math.max(map[r - 1][c + i], map[r + 1][c + i]);
						one = Math.max(one, temp);
					}
					sum += one;
					max = Math.max(sum, max);
				}

				if (r + 2 <= N + 1 && c + 2 <= M + 1) {
					int sum = map[r][c] + map[r + 1][c] + map[r][c + 1] + map[r + 1][c + 1];
					int temp = map[r][c] + map[r + 1][c] + map[r + 1][c + 1] + map[r + 2][c + 1];
					sum = Math.max(sum, temp);
					temp = map[r][c] + map[r][c + 1] + map[r + 1][c + 1] + map[r+1][c + 2];
					sum = Math.max(sum, temp);
					temp = map[r][c] + map[r][c + 1] + map[r + 1][c] + map[r + 1][c - 1];
					sum = Math.max(sum, temp);
					temp = map[r][c] + map[r + 1][c] + map[r + 1][c - 1] + map[r + 2][c - 1];
					sum = Math.max(sum, temp);
					max = Math.max(sum, max);
				}

			}
		}
		System.out.println(max);

	}
}
