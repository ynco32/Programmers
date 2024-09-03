import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	static int V;
	static int E;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			visited = new int[V + 1];
			graph = new ArrayList<>();
			for (int i = 0; i <= V; i++) {
				graph.add(new ArrayList<Integer>());
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				graph.get(num1).add(num2);
				graph.get(num2).add(num1);
			}

			flag = true;
			for (int i = 1; i <= V; i++) {
				if (!flag)
					break;
				if (visited[i] == 0) {
					bfs(i, 1);
				}
			}

			if (flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

	static void bfs(int v, int color) {
		Queue<Integer> q = new LinkedList<>();
		visited[v] = color;
		q.offer(v);
		while (!q.isEmpty() && flag) {
			int cur = q.poll();

			for (int i = 0; i < graph.get(cur).size(); i++) {
				int nv = graph.get(cur).get(i);
				if (visited[nv] == 0) {
					visited[nv] = (-1) * visited[cur];
					q.offer(nv);
				} else if (visited[nv] + visited[cur] != 0) {
					flag = false;
					return;
				}
			}

		}
	}

}
