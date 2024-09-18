/*

4 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int to;
		int weight;

		Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}

	static int N, E;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[] dist;
	static final int INF = Integer.MAX_VALUE / 3;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		dist = new int[N + 1];

		Arrays.fill(dist, INF);

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Node>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.get(from).add(new Node(to, weight));
			graph.get(to).add(new Node(from, weight));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int temp1 = 0;
		temp1 += dijkstra(1, v1);
		temp1 += dijkstra(v1, v2);
		temp1 += dijkstra(v2, N);

		int temp2 = 0;
		temp2 += dijkstra(1, v2);
		temp2 += dijkstra(v2, v1);
		temp2 += dijkstra(v1, N);

		int ans;
		if (temp1 >= INF && temp2 >= INF) {
			ans = -1;
		} else
			ans = Math.min(temp1, temp2);

		System.out.println(ans);
	}

	public static int dijkstra(int start, int end) {
		Arrays.fill(dist, INF);
		boolean[] visited = new boolean[N + 1];

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.to;

			if (visited[cur])
				continue;

			visited[cur] = true;

			for (Node node : graph.get(cur)) {
				if (!visited[node.to] && dist[node.to] > dist[cur] + node.weight) {
					dist[node.to] = dist[cur] + node.weight;
					pq.add(new Node(node.to, dist[node.to]));
				}
			}
		}

		return dist[end];
	}
}
