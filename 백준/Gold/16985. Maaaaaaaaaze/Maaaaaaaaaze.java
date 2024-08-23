
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] array;
	static int[] arrayC;
	static int[][][][] input;
	static boolean[][][] visited;
	static boolean[] visitedC;
	static int[][][] copyCube;
	static int ans = Integer.MAX_VALUE;

	static int[] dh = { 1, -1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		input = new int[4][5][5][5]; // [회전수][주어진 높이][r][c]
		visited = new boolean[5][5][5]; // bfs에 사용
		visitedC = new boolean[5]; // 판 순서 순열에 사용
		array = new int[5]; // 각 판 당 회전수
		arrayC = new int[5]; // 판 순서
		copyCube = new int[5][5][5]; 
		
		// 입력값 받아옴
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 5; k++) {
					input[0][i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		// 판 돌리는 경우
		for (int turn = 1; turn < 4; turn++) {
			for (int k = 0; k < 5; k++) {
				for (int r = 0; r < 5; r++) {
					for (int c = 0; c < 5; c++) {
						input[turn][k][c][5 - r - 1] = input[turn - 1][k][r][c];
					}
				}
			}
		}
		
		dfs(0);

		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}

		System.out.println(ans);

	}

	static void dfs(int depth) {//  판 돌리는 중복 순열
		if (depth == 5) {
			dfs2(0);
			return;
		}
		for (int i = 0; i < 4; i++) {
			array[depth] = i;
			dfs(depth + 1);

		}

	}

	static void dfs2(int depth) { // 판 순서 
		if (depth == 5) {
			for (int i = 0; i < 5; i++) {
				copyCube[i] = input[array[i]][arrayC[i]];
			}
			if (copyCube[0][0][0] == 1) // 시작점이 1일 때 bfs 시작
				bfs(0, 0, 0);
			return;
		}

		for (int i = 0; i < 5; i++) {
			if (!visitedC[i]) {
				arrayC[depth] = i;
				visitedC[i] = true;
				dfs2(depth + 1);
				visitedC[i] = false;
			}

		}
	}

	static void bfs(int h, int r, int c) {
		visited = new boolean[5][5][5];
		visited[h][r][c] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { h, r, c, 0 });

		while (!q.isEmpty()) {
			int[] current = q.poll();
			// 탈출 조건
			if (current[0] == 4 && current[1] == 4 && current[2] == 4) {
				if (ans > current[3]) 
					ans = current[3];
				return;
			}

			for (int d = 0; d < 6; d++) {
				int nh = current[0] + dh[d];
				int nr = current[1] + dr[d];
				int nc = current[2] + dc[d];
				int cnt = current[3] + 1;

				if (nh >= 0 && nr >= 0 && nc >= 0 && nh < 5 && nc < 5 && nr < 5 && !visited[nh][nr][nc]) {
					// 큐브 1일때 / 지금까지 cnt가 저장된 답보다 작을 떄만 큐에 저장
					if (copyCube[nh][nr][nc] == 1 && cnt < ans) {
						int[] temp = { nh, nr, nc, cnt };
						visited[nh][nr][nc] = true;
						q.offer(new int[] { nh, nr, nc, cnt });
					}
				}

			}

		}

	}

}
