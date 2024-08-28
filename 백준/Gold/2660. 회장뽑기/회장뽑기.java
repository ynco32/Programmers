
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int i = 0; i < N + 1; i++)
			graph.add(new ArrayList<Integer>());

		while (true) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			if (num1 == -1 && num2 == -1)
				break;
			graph.get(num1).add(num2);
			graph.get(num2).add(num1);
		}

		int[] score = new int[N + 1];

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			score[i] = bfs(i);
			if (score[i] < min)
				min = score[i];
		}

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (score[i] == min)
				cnt++;
		}
		System.out.println(min + " " + cnt);
		for (int i = 1; i <= N; i++) {
			if (score[i] == min)
				System.out.print(i + " ");
		}

	}

	static int bfs(int v) {
		boolean[] visited = new boolean[N + 1];
		int[] depth = new int[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		depth[v] = 0;
		int max = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			visited[cur] = true;

			for (int i = 0; i < graph.get(cur).size(); i++) {
				int nv = graph.get(cur).get(i);
				if (!visited[nv]) {
					depth[nv] = depth[cur] + 1;
					if (depth[nv] > max)
						max = depth[nv];

					visited[nv] = true;
					q.offer(nv);
				}
			}
		}
		return max;

	}
}
