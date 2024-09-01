
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;
	static int V;

	static void makeSet() {
		parents = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			parents[i] = -1;
		}
	}

	static int find(int a) {
		if (parents[a] < 0)
			return a;

		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;

		parents[aRoot] = bRoot;
		return true;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		ArrayList<int[]> edges = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edges.add(new int[] { num1, num2, cost });
		}

		long cost = 0;
		int cnt = 0;
		int last = 0;
		makeSet();
		Collections.sort(edges, (o1, o2) -> o1[2] - o2[2]);

		for (int i = 0; i < edges.size(); i++) {
			int[] edge = edges.get(i);
			if (union(edge[0], edge[1])) {
				cost += edge[2];
				last = edge[2];
				if (++cnt == V - 1)
					break;
			}
		}

		System.out.println(cost-last);

	}
}
