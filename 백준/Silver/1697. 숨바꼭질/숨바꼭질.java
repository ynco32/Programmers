import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n;
	static int k;
	static int cnt = 0;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		visited = new boolean[100001];
		
		System.out.println(bfs(n));
		
	}
	
	static int bfs(int v) {
		cnt = 0;
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> cntQueue = new LinkedList<>();
		queue.add(v);
		cntQueue.add(cnt);
//		visited[v] = true;
		
		while (!queue.isEmpty()) {
			v = queue.poll();
			cnt = cntQueue.poll();
			
			if (!visited[v]) {
				visited[v] = true;
				if (v == k) return cnt;
					
				cnt++;
				
				if (v*2 < 100001){
					queue.add(v*2);
					cntQueue.add(cnt);
				}
				if (v+1 < 100001){
					queue.add(v+1);
					cntQueue.add(cnt);
				}
				if (v >= 1){
					queue.add(v-1);
					cntQueue.add(cnt);
				}
			}
		}
		
		return cnt;
	}

}

