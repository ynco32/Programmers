
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int max;
	static int[] ans;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		graph = new ArrayList<>();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		ans = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			graph.get(num1).add(num2);
//			graph.get(num2).add(num1);
		}

		max = Integer.MIN_VALUE;
		for (int i = 1; i < N + 1; i++) {
			visited = new boolean[N + 1];
			
			visited[i] = true;
			Queue<Integer> q = new LinkedList<>();
			q.offer(i);
			
			while (!q.isEmpty()) {
				int current = q.poll();

				for (int j = 0; j < graph.get(current).size(); j++) {
					int nv = graph.get(current).get(j);
					if (!visited[nv]) {
						ans[nv]++;
						visited[nv] = true;
						q.offer(nv);
					}
				}
			}

		}
		for (int i = 1; i < N + 1; i++) {
			max = Math.max(max, ans[i]);
		}

		for (int i = 1; i < N + 1; i++) {
			if (ans[i] == max)
				System.out.print(i + " ");
		}

	}

}
