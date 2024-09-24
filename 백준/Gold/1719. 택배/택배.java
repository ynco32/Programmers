import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int to, cost;

		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[][] ans;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ans = new int[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Node>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, cost));
			graph.get(b).add(new Node(a, cost));
		}
		for (int i = 1; i <= N; i++) {
			dijkstra(i);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j)
					sb.append(ans[i][j]).append(" ");
				else
					sb.append("- ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void dijkstra(int start) {
		boolean[] visited = new boolean[N + 1];
		int[] cost = new int[N + 1];

		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node current = pq.poll();

			if (cost[current.to] < current.cost) {
				continue;
			}
			if (!visited[current.to])
				visited[current.to] = true;

			for (int i = 0; i < graph.get(current.to).size(); i++) {
				Node next = graph.get(current.to).get(i);

				if (!visited[next.to] && cost[next.to] > current.cost + next.cost) {
					cost[next.to] = current.cost + next.cost;
					ans[next.to][start] = current.to;
					pq.offer(new Node(next.to, cost[next.to]));
				}
			}

		}
	}
}
