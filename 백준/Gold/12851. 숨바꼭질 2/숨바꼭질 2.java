
import java.util.ArrayList;
import java.util.Collections;
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
		if (n == k) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		bfs(n);

		System.out.println(visited[k] - 1);
		System.out.println(cnt);
	}

	static void bfs(int v) {
		cnt = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = 1;

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			if (visited[k] != 0 && visited[k] < visited[cur] + 1)
				return;

			if (cur * 2 < 100001) {
				int nv = cur * 2;

				if (visited[nv] == 0 || visited[nv] >= visited[cur] + 1) {
					visited[nv] = visited[cur] + 1;
					queue.add(nv);
				}

				if (nv == k) {
					cnt++;
				}
			}
			if (cur + 1 < 100001) {
				int nv = cur + 1;
				if (visited[nv] == 0 || visited[nv] >= visited[cur] + 1) {
					visited[nv] = visited[cur] + 1;
					queue.add(nv);
				}

				if (nv == k) {
					cnt++;
				}
			}
			if (cur >= 1) {
				int nv = cur - 1;
				if (visited[nv] == 0 || visited[nv] >= visited[cur] + 1) {
					visited[nv] = visited[cur] + 1;
					queue.add(nv);

				}

				if (nv == k) {
					cnt++;
				}
			}
		}
	}

}
