
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs 한번만 써봅시다!!!
public class Main {
	static int N;
	static int M;
	static boolean flag;
	static boolean[][] visited0;
	static boolean[][] visited1;
	static int[][] map;
	static ArrayList<Integer> cnts;
	static int cnt;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited0 = new boolean[N][M];
		visited1 = new boolean[N][M];
		
		
		for (int i = 0; i < N; i++) {
			String tempInput = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tempInput.charAt(j)-'0';
			}
		}
		cnts = new ArrayList<>();
//		flag = false;
		cnt = 0;
		visited0[0][0] = true;
		visited1[0][0] = true;
		bfs(0, 0, 0, 1);
		
		if (!cnts.isEmpty()) {
			cnts.sort(null);
			System.out.println(cnts.get(0));
		}
		else if (N == 1 && M == 1) System.out.println(1);
		else System.out.println(-1);
	}
	
	static void bfs(int r, int c, int w, int step) {
		Queue<int[]> q = new LinkedList<>();
		int[] v = { r, c, w, step };
		q.offer(v);
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];
				
				
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
					if (map[nr][nc] == 1) {
						if (temp[2] == 0 && !visited0[nr][nc]) {
							if (nr == N-1 && nc == M-1) {
//								flag = true;
//								cnt = temp[3] + 1;
								cnts.add(temp[3]+1);
								return;
							}
							int[] next = { nr, nc, 1, temp[3]+1};
							q.offer(next);
							visited1[nr][nc] = true;
						}
					} else if (map[nr][nc] == 0) {
						if (nr == N-1 && nc == M-1) {
//							flag = true;
//							cnt = temp[3] + 1;
							cnts.add(temp[3]+1);
							return;
						}
						
						if (temp[2] == 0 && !visited0[nr][nc]) {
							int[] next = { nr, nc, 0, temp[3]+1};
							q.offer(next);
							visited0[nr][nc] = true;
						}
						else if (temp[2] == 1 && !visited1[nr][nc]) {
							int[] next = { nr, nc, 1, temp[3]+1};
							q.offer(next);
							visited1[nr][nc] = true;
						}
						
					}
				}
			}
			
			
			
			
		}
		
		
	}
}
