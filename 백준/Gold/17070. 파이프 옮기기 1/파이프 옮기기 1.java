
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Pipe {
		int r1, c1;
		int r2, c2;
		int status;

		public Pipe(int r1, int c1, int r2, int c2, int status) {
			super();
			this.r1 = r1;
			this.c1 = c1;
			this.r2 = r2;
			this.c2 = c2;
			this.status = status;
		}

		@Override
		public String toString() {
			return "Pipe [r1=" + r1 + ", c1=" + c1 + ", r2=" + r2 + ", c2=" + c2 + ", status=" + status + "]";
		}

	}

	static int N, map[][];
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		bfs();
		System.out.println(ans);
	}

	static void bfs() {
		Queue<Pipe> q = new LinkedList<>();
		// r1, c1, r2, c2, status: 0-horizontal 1-vertical 2-diagonal
		Pipe start = new Pipe(0, 0, 0, 1, 0);
		q.offer(start);

		while (!q.isEmpty()) {
			Pipe current = q.poll();

			if (current.r2 == N - 1 && current.c2 == N - 1) {
				ans++;
				continue;
			}

			if (current.r2 + 1 < N && current.c2 + 1 < N && map[current.r2][current.c2 + 1] == 0
					&& map[current.r2 + 1][current.c2] == 0 && map[current.r2 + 1][current.c2 + 1] == 0) {
				q.offer(new Pipe(current.r2, current.c2, current.r2 + 1, current.c2 + 1, 2));
			}

			if (current.status == 0) {
				if (current.c2 + 1 < N && map[current.r2][current.c2 + 1] == 0) {
					q.offer(new Pipe(current.r2, current.c2, current.r2, current.c2 + 1, 0));
				}
			}

			else if (current.status == 1) {
				if (current.r2 + 1 < N && map[current.r2 + 1][current.c2] == 0) {
					q.offer(new Pipe(current.r2, current.c2, current.r2 + 1, current.c2, 1));
				}
			}

			else if (current.status == 2) {
				if (current.r2 + 1 < N && map[current.r2 + 1][current.c2] == 0) {
					q.offer(new Pipe(current.r2, current.c2, current.r2 + 1, current.c2, 1));
				}

				if (current.c2 + 1 < N && map[current.r2][current.c2 + 1] == 0) {
					q.offer(new Pipe(current.r2, current.c2, current.r2, current.c2 + 1, 0));
				}
			}

		}

	}
}
