
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int cnt = 0;
	static ArrayList<Position> blank = new ArrayList<>();
	static ArrayList<Position> virus = new ArrayList<>();
	static Position walls[] = new Position[3];
	static ArrayList<Integer> cnts = new ArrayList<>();
	
	static int[] dx = { 1, -1, 0, 0};
	static int[] dy = { 0, 0, 1, -1};
	
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
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					blank.add(new Position(j,i));
				}
				
				else if (map[i][j] == 2) {
					virus.add(new Position(j,i));
				}
			}
		}
		
		
		makeWall(0, 0);
//		System.out.println(cnts);
		cnts.sort(null);
		System.out.println(cnts.get(cnts.size()-1));
		
	}

	
	static void makeWall(int idx, int targetIdx) {
		if (targetIdx == 3) {
//			System.out.println("조합 1개 끝");
//			System.out.println(Arrays.toString(walls));
			int [][] newMap = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++)  {
					newMap[i][j] = map[i][j];
				}
			}
//			System.out.println(Arrays.deepToString(map));
			newMap[walls[0].y][walls[0].x] = 1;
			newMap[walls[1].y][walls[1].x] = 1;
			newMap[walls[2].y][walls[2].x] = 1;
			
			
			boolean[][] visited = new boolean[N][M];
			cnt = 0;
//					bfs(virus.get(0).x, virus.get(0).y, newMap, visited);	
			for (int i = 0; i < virus.size(); i++) {
				Position vir = virus.get(i);
				if (!visited[vir.y][vir.x]) {
					bfs(virus.get(i).x, virus.get(i).y, newMap, visited);	
				}
//				System.out.println("bfs 끝?");
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M;j++) {
					if (newMap[i][j] == 0) cnt++;
				}
			}
			cnts.add(cnt);
			newMap[walls[0].y][walls[0].x] = 0;
			newMap[walls[1].y][walls[1].x] = 0;
			newMap[walls[2].y][walls[2].x] = 0;

			return;
		}

		for (int i = idx; i < blank.size(); i++) {
			walls[targetIdx] = blank.get(i);
			makeWall(i+1, targetIdx+1);
		}
	}
	
	
	static void bfs(int x, int y, int[][] map2, boolean[][] visited) {
		Queue<Position> queue = new LinkedList<>();
		queue.offer(new Position(x,y));
		visited[y][x] = true;
		int nx = 0;
		int ny = 0;
		
		while(!queue.isEmpty()) {
			
			Position temp = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				nx = temp.x + dx[d];
				ny = temp.y + dy[d];
				
				if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
					if (map2[ny][nx] == 0) {
						map2[ny][nx] = 2;
						queue.add(new Position(nx,ny));
						visited[ny][nx] = true;
					}
					
				}
			}
			
			
		}
		
		
		
//		System.out.println(Arrays.toString(walls));
//		System.out.println(Arrays.deepToString(map2));
//		System.out.println(cnt);
		
	}
	
}

