
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Position {
		int x;
		int y;
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		while (t-- > 0) {
			ArrayList<Position> loc = new ArrayList<>();
			Queue<Position> q = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			boolean[] visited = new boolean[n + 2];
			int xS = Integer.parseInt(st.nextToken());
			int yS = Integer.parseInt(st.nextToken());
			Position home = new Position( xS, yS );
			loc.add(home);
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int xC = Integer.parseInt(st.nextToken());
				int yC = Integer.parseInt(st.nextToken());
				Position con = new Position( xC, yC );
				loc.add(con);
			}
			st = new StringTokenizer(br.readLine());
			int xP = Integer.parseInt(st.nextToken());
			int yP = Integer.parseInt(st.nextToken());
			Position pen = new Position( xP, yP );
			loc.add(pen);

			q.offer(home);
			visited[0] = true;

			while (!q.isEmpty()) {
				Position temp = q.poll();

				int distP = Math.abs(temp.x - xP) + Math.abs(yP - temp.y);

				if (distP <= 1000) {
					visited[n + 1] = true;
					break;
				}

				for (int i = 1; i < n+1; i++) {
					if (!visited[i]) {
						Position next = loc.get(i);
						int dist = Math.abs(next.x - temp.x) + Math.abs(next.y - temp.y);
						if (dist <= 1000) {
							visited[i] = true;
							q.offer(next);
						}
					}

				}

			}

			if (visited[n + 1])
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}
}
