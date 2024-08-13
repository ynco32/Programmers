
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] visited;
	static int F;
	static int S;
	static int G;
	static int U;
	static int D;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visited = new boolean[F+1];
		cnt = 0;
		cnt = bfs(S);
		
		
		if (!visited[G]) System.out.println("use the stairs");
		else System.out.println(cnt);
	}
	
	static int bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> cq = new LinkedList<>();
		q.offer(v);
		cq.offer(1);
//		visited[v] = true;
		
		while (!q.isEmpty()) {
			int temp = q.poll();
			int c = cq.poll();
			
			if (!visited[temp]) {
				visited[temp] = true;
				if (temp + U == G || temp - D == G) {
					visited[G] = true;
					return c;
				}
				
				c++;
				
				if (temp+U <= F) {
					q.offer(temp+U);
					cq.offer(c);
					
				}
				
				if (temp-D > 0) {
					q.offer(temp-D);
					cq.offer(c);
					
				}
			}
			
		}
		return cnt;
		
		
	}
	
}
