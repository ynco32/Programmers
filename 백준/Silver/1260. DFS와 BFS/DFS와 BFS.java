

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] graph = new int[1001][1001];
	static int N, M; //N 정점 개수 M 간선 개수 
	static boolean[] visited = new boolean [1001];
	static Queue<Integer> que = new LinkedList<>();
	static StringBuilder sb_dfs = new StringBuilder();
	static StringBuilder sb_bfs = new StringBuilder();


	public static void dfs(int v) {
		//들어온 node true로 바꿔줌 
		visited[v] = true;
		
		sb_dfs.append(v).append(" ");

		//recursion
		for (int i = 0; i < N; i++) {
			//그래프에 있고 아직 방문하지 않은 node 찾
			if (graph[v][i+1] == 1 && !visited[i+1]) dfs(i+1);
		}

	}

	public static void bfs(int v) {
		//들어온 node true로 바꿔주고 queue에 add
		visited[v] = true;
		que.add(v);
		
		while(!que.isEmpty()) {
			//queue에 있는 node 다 비울 때까지 반복 
			v = que.poll();
			sb_bfs.append(v).append(" ");
			
			for (int i = 0; i < N; i++) {
				//그래프에 있고 아직 방문하지 않은 node 찾
				if (graph[v][i+1] == 1 && !visited[i+1]) {
					que.add(i+1);
					visited[i+1] = true;
					
				}
			}
		}
		que.clear();

	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int start = sc.nextInt();
		
		//그래프 만들기 
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		dfs(start);
		System.out.println(sb_dfs);
		// 방문 여부 초기화 
		visited = new boolean[1001];
		bfs(start);
		System.out.println(sb_bfs);
	}
}
