

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int V;
	static boolean[] visited;
	static LinkedList<Integer>[] graph;
	static int cnt=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int V = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		graph = new LinkedList[N+1];
		for (int i = 0; i < N; i++) {
			graph[i+1] = new LinkedList<>();
		}
		
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		System.out.println(bfs(1));
				
	}
	
	
	static int bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visited[v] = true;
		
		while (!queue.isEmpty()) {
			int cv = queue.poll();
			
			for (int i = 0; i < graph[cv].size(); i++) {
				int nv = graph[cv].get(i);
				if (!visited[nv]) {
					cnt++;
					visited[nv] = true;
					queue.offer(nv);
				}
			}
		}
		
		return cnt;
	}
}
