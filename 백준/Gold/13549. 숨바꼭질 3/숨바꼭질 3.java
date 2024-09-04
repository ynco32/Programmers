import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n;
	static int k;
	static int cnt = 0;
	static int[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		visited = new int[100001];

		bfs(n);
		System.out.println(visited[k] - 1);

	}

	static int bfs(int v) {
		cnt = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = 1;

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			cnt = visited[cur];

			if (cur == k)
				return cnt;

			cnt++;

			if (cur * 2 < 100001) {
				
				if (visited[cur * 2] > cnt - 1 || visited[cur * 2] == 0){
                    queue.add(cur * 2);
                    visited[cur * 2] = cnt - 1;
                }
					
			}
			if (cur + 1 < 100001) {
				
				if (visited[cur + 1] > cnt || visited[cur + 1] == 0){
                    visited[cur + 1] = cnt;
                    queue.add(cur + 1);
                }
					
			}
			if (cur >= 1) {
				
				if (visited[cur - 1] > cnt || visited[cur - 1] == 0){
                    visited[cur - 1] = cnt;
                    queue.add(cur - 1);
                }
					
			}
		}

		return cnt;
	}

}