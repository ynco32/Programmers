
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static boolean[] current;
	static ArrayList<int[]>[] locked;
	static int W, H;
	static int ans;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H+2][W+2];
			locked = new ArrayList[26];
			for (int i = 0; i < 26; i++) {
				locked[i] = new ArrayList<int[]>();
			}

			for (int i = 0; i < H + 2; i++) {
				for (int j = 0; j < W + 2; j++) {
					map[i][j] = '.';
				}
			}

			for (int i = 1; i <= H; i++) {
				String input = br.readLine();
				for (int j = 1; j <= W; j++) {
					map[i][j] = input.charAt(j - 1);
				}
			}

			current = new boolean[26];

			String keys = br.readLine();
			if (!keys.equals("0")) {
				for (int i = 0; i < keys.length(); i++) {
					int key = keys.charAt(i) - 'a';
					current[key] = true;
				}
			}

			ans = 0;
			bfs();

			System.out.println(ans);

		}

	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[H + 2][W + 2];
		q.offer(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if (nr < 0 || nc < 0 || nr >= H+2 || nc >= W+2 || visited[nr][nc])
					continue;
				
				
				char get = map[nr][nc];
				if (get == '*')
					continue;
				else if (get == '.') {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc});
				}
				else if (get == '$') {
					ans++;
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc});
				}
				else {
					if (get >= 'A' && get <= 'Z') {
						int door = (int) get - (int)'A';
						
						if (current[door]) {
							map[nr][nc] = '.';
							visited[nr][nc] = true;
							q.offer(new int[] {nr, nc});
						}
						else {
							locked[door].add(new int[] {nr, nc});
						}
					}
					
					else {
						int k = (int) get - (int)'a';
						current[k] = true;
						visited[nr][nc] = true;
						q.offer(new int[] {nr, nc});
						
						if (!locked[k].isEmpty()) {
							for (int[] un: locked[k]) {
								map[un[0]][un[1]] = '.';
								visited[un[0]][un[1]] = true;
								q.offer(un);
							}
						}
						
					}
				}
			}
		}

	}
}
