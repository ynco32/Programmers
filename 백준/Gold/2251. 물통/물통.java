
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][][] waterVisited;
	static int A;
	static int B;
	static int C;
	static ArrayList<Integer> ans = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		waterVisited = new boolean[201][201][201];

		bfs(0, 0, C);
		Collections.sort(ans);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
	}

	static void bfs(int a, int b, int c) {
//		waterVisited[a][b][c] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { a, b, c });

		while (!q.isEmpty()) {
			int[] current = q.poll();
			int curA = current[0];
			int curB = current[1];
			int curC = current[2];

			if (waterVisited[curA][curB][curC])
				continue;

			waterVisited[curA][curB][curC] = true;
			if (curA == 0)
				ans.add(curC);

			// A > B
			if (curA + curB>= B)
				q.offer(new int[] { curA - (B - curB), B, curC });
			else
				q.offer(new int[] { 0, curA + curB, curC });

			// A > C
			if (curA + curC >= C)
				q.offer(new int[] { curA - (C - curC), curB, C });
			else
				q.offer(new int[] { 0, curB, curA + curC });

			// B > A
			if (curB + curA >= A)
				q.offer(new int[] { A, curB - (A - curA), curC });
			else
				q.offer(new int[] { curA + curB, 0, curC });

			// B > C
			if (curB + curC >= C)
				q.offer(new int[] { curA, curB - (C - curC), C });
			else
				q.offer(new int[] { curA, 0, curB + curC });

			// C > A
			if (curC + curA >= A)
				q.offer(new int[] { A, curB, curC - (A - curA) });
			else
				q.offer(new int[] { curA + curC, curB, 0 });

			// C > B
			if (curC + curB >= B)
				q.offer(new int[] { curA, B, curC - (B - curB) });
			else
				q.offer(new int[] { curA, curB + curC, 0 });

		}

	}
}
