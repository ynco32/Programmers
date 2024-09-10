
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int X;
	static int dist[];
	static int reDist[];
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static ArrayList<ArrayList<Node>> reverse = new ArrayList<>();

	static class Node implements Comparable<Node> {
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Node>());
			reverse.add(new ArrayList<Node>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.get(from).add(new Node(to, weight));
			reverse.get(to).add(new Node(from, weight));

		}

		dijkstra();
		dijkstraR();

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(dist[i] + reDist[i], ans);
		}
		System.out.println(ans);
	}

	static void dijkstra() {
		boolean[] visited = new boolean[N + 1];
		dist = new int[N + 1];
		int INF = Integer.MAX_VALUE;

		Arrays.fill(dist, INF);
		dist[X] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(X, 0));

		while (!pq.isEmpty()) {
			int cur = pq.poll().to;

			if (visited[cur])
				continue;
			visited[cur] = true;

			for (Node next : graph.get(cur)) {
				if (dist[next.to] > dist[cur] + next.weight) {
					dist[next.to] = dist[cur] + next.weight;
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
		}

	}

	static void dijkstraR() {
		boolean[] visited = new boolean[N + 1];
		reDist = new int[N + 1];
		int INF = Integer.MAX_VALUE;

		Arrays.fill(reDist, INF);
		reDist[X] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(X, 0));

		while (!pq.isEmpty()) {
			int cur = pq.poll().to;

			if (visited[cur])
				continue;
			visited[cur] = true;

			for (Node next : reverse.get(cur)) {
				if (reDist[next.to] > reDist[cur] + next.weight) {
					reDist[next.to] = reDist[cur] + next.weight;
					pq.offer(new Node(next.to, reDist[next.to]));
				}
			}
		}

	}
}
