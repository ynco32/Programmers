import java.util.Scanner;

public class Main {
	static int[][] graph;	// 방향그래프 인접 행렬
	static int[][] path;	// 결과 출력할 2차원 배열
	static boolean[] visit;	// 탐색 여부 체크
	static int N;			// 정점의 갯수

	public static void dfs(int x, int y) {
		visit[y] = true;	// 각 행마다 열을 기준으로 체크하므로 y값 체크
		path[x][y] = 1;		// x -> y로 이동하는 경로 존재, 1로 설정

		for(int i=0; i<N; i++) {
			if(graph[y][i] == 1 && visit[i] == false) {
				dfs(x, i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		graph = new int[N][N];
		path = new int[N][N];
		visit = new boolean[N];

		// 그래프의 인접 행렬
		// i => j 간선이 존재하면 1, 존재하지 않으면 0
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				graph[i][j] = scan.nextInt();
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				visit[j] = false;	// 행(i) 마다 경로를 탐색해야 하므로 방문한곳 초기화
			}

			for(int j=0; j<N; j++) {
				if(graph[i][j] == 1 && visit[j] == false) {
					dfs(i, j);
				}
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(path[i][j] + " ");
			}
			System.out.println();
		}
	}
}