import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K;
	static int W;
	static int H;
	static int[][] map;
	static boolean[][][] visited;
	static ArrayList<Integer> cnts;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[] hdr = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] hdc = { 1, -1, 2, -2, 2, -2, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[K + 1][H][W];
		cnts = new ArrayList<>();

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(0, 0, 0, 0);

		if (!cnts.isEmpty()) {
			cnts.sort(null);
			System.out.println(cnts.get(0));
		} else if (W == 1 && H == 1)
			System.out.println(0);
		else
			System.out.println(-1);
	}

	static void bfs(int r, int c, int k, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		int[] v = { r, c, k, cnt };
		q.offer(v);
		visited[k][r][c] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];

				if (nr == H - 1 && nc == W - 1 && !visited[temp[2]][nr][nc]) {
					cnts.add(temp[3] + 1);
					return;
				}

				if (nr >= 0 && nc >= 0 && nc < W && nr < H) {
					if (map[nr][nc] == 0) {

						if (nr == H - 1 && nc == W - 1) {
							cnts.add(temp[3] + 1);
							return;
						}
						if (!visited[temp[2]][nr][nc]) {
							int[] next = { nr, nc, temp[2], temp[3] + 1 };
							visited[temp[2]][nr][nc] = true;
							q.offer(next);
						}
					}
				}
			} //

			for (int d = 0; d < 8; d++) {
				int nr = temp[0] + hdr[d];
				int nc = temp[1] + hdc[d];
				if (nr >= 0 && nc >= 0 && nc < W && nr < H) {
					if (temp[2] < K) {
						if (nr == H - 1 && nc == W - 1 && !visited[temp[2] + 1][nr][nc]) {
							cnts.add(temp[3] + 1);
							return;
						}
						if (map[nr][nc] == 0 && !visited[temp[2] + 1][nr][nc]) {
							int[] next = { nr, nc, temp[2] + 1, temp[3] + 1 };
							visited[temp[2] + 1][nr][nc] = true;
							q.offer(next);

						}
					}
				}
			}

		}

	}
}
