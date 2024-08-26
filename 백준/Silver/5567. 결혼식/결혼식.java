
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			graph.get(num1).add(num2);
			graph.get(num2).add(num1);
		}

		visited = new boolean[N + 1];
		dfs(1);
		
		System.out.println(cnt);

	}

	static void dfs(int v) {
		visited[v] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {v, 0});
		cnt = 0;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			
			if (temp[1] >= 2)
				return;

			for (int i = 0; i < graph.get(temp[0]).size(); i++) {
				int tmp = graph.get(temp[0]).get(i);
				if (!visited[tmp]) {
					visited[tmp] = true;
					q.offer(new int[] {tmp, temp[1]+1});
					cnt++;
					
				}
			}
			
			
		}
		
	}
}
