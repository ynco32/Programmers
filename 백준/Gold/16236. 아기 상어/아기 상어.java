
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int dr[] = { -1, 0, 0, 1 };
	static int dc[] = { 0, -1, 1, 0 };
	static int N, sizeS, cnt, total, curR, curC;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int ans = 0;
		map = new int[N][N];
		sizeS = 2;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 9) {
					curR = i;
					curC = j;
					map[i][j] = 0;
				}
			}
		}

		int temp = bfs(curR, curC);

//		System.out.println(temp);
		while (temp > 0) {
			ans += temp;
			temp = bfs(curR, curC);
		}
		System.out.println(ans);

	}

	static int bfs(int r, int c) {
		visited = new boolean[N][N];
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
			if (o1[2] == o2[2]) { // 거리 비교
				if (o1[0] == o2[0]) { // 행 비교
					return o1[1] - o2[1]; // 열 비교
				}
				return o1[0] - o2[0];
			}
			return o1[2] - o2[2];
		});

		q.add(new int[] { r, c, 0 });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			int cs = cur[2];

			if (map[cr][cc] < sizeS && map[cr][cc] > 0) {
				map[cr][cc] = 0; 
				cnt++;
				if (cnt == sizeS) { 
					sizeS++;
					cnt = 0;
				}
				curR = cr; 
				curC = cc;
				return cs;
			}

			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];

				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {
					if (map[nr][nc] <= sizeS) { 
						visited[nr][nc] = true;
						q.add(new int[] { nr, nc, cs + 1 });
					}
				}
			}
		}

		return -1; 
	}

}
