
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int N;
	static boolean[] visited;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {

			N = Integer.parseInt(br.readLine());
			ans = 0;
			graph.clear();
			for (int i = 0; i <= N; i++) {
				graph.add(new ArrayList<Integer>());
			}

			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				graph.get(b).add(a);
			}

			st = new StringTokenizer(br.readLine());
			int findA = Integer.parseInt(st.nextToken());
			int findB = Integer.parseInt(st.nextToken());

			visited = new boolean[N + 1];

			dfs(findA);
			dfs(findB);
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int v) {

		if (visited[v]) {
			ans = v;
			return;
		}

		visited[v] = true;

		for (int node : graph.get(v)) {
			dfs(node);
		}
	}
}
