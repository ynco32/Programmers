import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	static int N, M;

	static void makeSet() {
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
	}

	static int find(int a) {
		if (parent[a] == a)
			return parent[a];
		else
			return parent[a] = find(parent[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parent[aRoot] = bRoot;

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		makeSet();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (cmd == 0) {
				union(a, b);
			}
			else {
				if (find(a) == find(b))
					sb.append("YES \n");
				else 
					sb.append("NO \n");
			}
			
		}
		
		System.out.println(sb);

	}

}
