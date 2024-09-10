import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int[] parent;

	static void makeSet() {
		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parent[i] = -1;
		}
	}

	static int find(int v) {
		if (parent[v] < 0)
			return v;
		return parent[v] = find(parent[v]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parent[bRoot] = aRoot;
		return true;

	}

	static class Line implements Comparable<Line> {
		int a, b, cost;

		public Line(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Line o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		Line[] list = new Line[M];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[i] = new Line(a, b, c);

		}

		Arrays.sort(list);

		makeSet();
		int cnt = 0;
		int cost = 0;
		for (int i = 0; i < M; i++) {
			if (union(list[i].a, list[i].b)) {
				cost += list[i].cost;
				cnt++;
			}

			if (cnt == N - 1)
				break;
		}
		
		System.out.println(cost);

	}

}
