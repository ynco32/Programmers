
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int R, C;
	static char[][] map;
	static int memory;
	static boolean ans;

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];
			ans = false;
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
			}

			memory = 0;
			bfs();
			
			sb.append("#").append(t).append(" ");
			
			if (ans) sb.append("YES");
			else sb.append("NO");
			
			sb.append("\n");

		}
		System.out.println(sb);
		
	}

	static void bfs() {
		boolean[][][][] visited = new boolean[R][C][4][16];

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, 0 });
		int dir = 0; // 0: 오, 1: 왼, 2: 하, 3: 상

		while (!q.isEmpty()) {

			int[] current = q.poll();
			int cr = current[0];
			int cc = current[1];
			int cd = current[2];

			if (map[cr][cc] == '<') {
				int[] np = move(1, cr, cc);
				if (visited[np[0]][np[1]][1][memory])
					continue;
				visited[np[0]][np[1]][1][memory] = true;
				q.offer(np);

			}

			else if (map[cr][cc] == '>') {
				int[] np = move(0, cr, cc);
				if (visited[np[0]][np[1]][0][memory])
					continue;
				visited[np[0]][np[1]][0][memory] = true;
				q.offer(np);
			}

			else if (map[cr][cc] == '^') {
				int[] np = move(3, cr, cc);
				if (visited[np[0]][np[1]][3][memory])
					continue;
				visited[np[0]][np[1]][3][memory] = true;
				q.offer(np);
			}

			else if (map[cr][cc] == 'v') {
				int[] np = move(2, cr, cc);
				if (visited[np[0]][np[1]][2][memory])
					continue;
				visited[np[0]][np[1]][2][memory] = true;
				q.offer(np);
			}

			else if (map[cr][cc] == '_') {
				if (memory == 0) {
					int[] np = move(0, cr, cc);
					if (visited[np[0]][np[1]][0][memory])
						continue;
					visited[np[0]][np[1]][0][memory] = true;
					q.offer(np);
				} else {
					int[] np = move(1, cr, cc);
					if (visited[np[0]][np[1]][1][memory])
						continue;
					visited[np[0]][np[1]][1][memory] = true;
					q.offer(np);
				}
			}

			else if (map[cr][cc] == '|') {
				if (memory == 0) {
					int[] np = move(2, cr, cc);
					if (visited[np[0]][np[1]][2][memory])
						continue;
					visited[np[0]][np[1]][2][memory] = true;
					q.offer(np);
				} else {
					int[] np = move(3, cr, cc);
					if (visited[np[0]][np[1]][3][memory])
						continue;
					visited[np[0]][np[1]][3][memory] = true;
					q.offer(np);
				}
			}

			else if (map[cr][cc] == '?') {
				for (int d = 0; d < 4; d++) {
					int[] np = move(d, cr, cc);
					if (visited[np[0]][np[1]][d][memory])
						continue;
					visited[np[0]][np[1]][d][memory] = true;
					q.offer(np);
				}
				
			}

			else if (map[cr][cc] == '.') {
				int[] np = move(cd, cr, cc);
				if (visited[np[0]][np[1]][cd][memory])
					continue;
				visited[np[0]][np[1]][cd][memory] = true;
				q.offer(np);
			}

			else if (map[cr][cc] == '@') {
				ans = true;
				return;
			}

			else if (map[cr][cc] == '+') {
				memory++;
				if (memory == 16) memory = 0;
				int[] np = move(cd, cr, cc);
				if (visited[np[0]][np[1]][cd][memory])
					continue;
				visited[np[0]][np[1]][cd][memory] = true;
				q.offer(np);
			}
			else if (map[cr][cc] == '-') {
				memory--;
				if (memory == -1) memory = 15;
				int[] np = move(cd, cr, cc);
				if (visited[np[0]][np[1]][cd][memory])
					continue;
				visited[np[0]][np[1]][cd][memory] = true;
				q.offer(np);
			}
			
			else {
				memory = map[cr][cc] - '0';
				int[] np = move(cd, cr, cc);
				if (visited[np[0]][np[1]][cd][memory])
					continue;
				visited[np[0]][np[1]][cd][memory] = true;
				q.offer(np);
			}

		}

	}

	static int[] move(int dir, int cr, int cc) {
		int[] np = new int[3];

		np[0] = cr + dr[dir];
		np[1] = cc + dc[dir];
		np[2] = dir;

		if (np[0] < 0)
			np[0] = R - 1;
		else if (np[0] >= R)
			np[0] = 0;
		if (np[1] < 0)
			np[1] = C - 1;
		else if (np[1] >= C)
			np[1] = 0;

		return np;
	}

}
