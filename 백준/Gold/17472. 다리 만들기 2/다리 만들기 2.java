import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int cnt = 1;
	static int[][] map, bridge;
	static int N, M, totalB;
	static int ans = Integer.MAX_VALUE;
	static int[] parent;

	static boolean union(int from, int to) {
		int fromR = findSet(from);
		int toR = findSet(to);

		if (fromR == toR)
			return false;
		else
			parent[toR] = fromR;
		return true;
	}

	static int findSet(int v) {
		if (parent[v] == v)
			return v;
		else
			return parent[v] = findSet(parent[v]);
	}

	static class Edge implements Comparable<Edge> {

		int a, b, w;

		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [a=" + a + ", b=" + b + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		totalB = N * (N - 1) / 2;
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = (-1) * Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1) {
					bfs(i, j);
					cnt++;
				}
			}
		}

		bridge = new int[cnt + 1][cnt + 1];
		for (int i = 0; i < cnt + 1; i++) {
			for (int j = 0; j < cnt + 1; j++) {
				bridge[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					makeBridge(i, j);
				}
			}
		}

		parent = new int[cnt + 1];
		for (int i = 1; i <= cnt; i++) {
			parent[i] = i;
		}

		ArrayList<Edge> graph = new ArrayList<>();

		for (int i = 1; i < cnt + 1; i++) {
			for (int j = i + 1; j < cnt + 1; j++) {
				if (bridge[i][j] < Integer.MAX_VALUE) {
					graph.add(new Edge(i, j, bridge[i][j]));
				}
			}
		}

		Collections.sort(graph);

		int ans = 0;
		int num = 0;
		for (int i = 0; i < graph.size(); i++) {
			Edge e = graph.get(i);
			if (union(e.a, e.b)) {
				ans += e.w;
				num++;
			}
		}

		for (int i = 1; i < cnt; i++) {
			if (num < cnt-2) {
				System.out.println(-1);
				return;
			}
		}

		System.out.println(ans);

	}

	private static void makeBridge(int r, int c) {
		int curLand = map[r][c];

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			boolean flag = true;
			int lenB = 0;

			if (nr >= N || nc >= M || nr < 0 || nc < 0 || map[nr][nc] == curLand) {
				continue;
			}

			while (!(map[nr][nc] > 0 && map[nr][nc] != curLand)) {
				nr += dr[d];
				nc += dc[d];

				if (nr >= N || nc >= M || nr < 0 || nc < 0 || map[nr][nc] == curLand) {
					flag = false;
					break;
				}

				lenB++;
				for (int td = 0; td < 4; td++) {
					int tr = nr + dr[td];
					int tc = nc + dc[td];

					if (tr >= N || tc >= M || tr < 0 || tc < 0)
						continue;
				}
			}

			if (flag && lenB > 1) {
				int newLand = map[nr][nc];
				bridge[curLand][newLand] = Math.min(bridge[curLand][newLand], lenB);
				bridge[newLand][curLand] = bridge[curLand][newLand];
			}
		}
	}

	private static void bfs(int r, int c) {
		map[r][c] = cnt;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] current = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (map[nr][nc] == -1) {
					map[nr][nc] = cnt;
					q.offer(new int[] { nr, nc });
				}
			}

		}
	}
}