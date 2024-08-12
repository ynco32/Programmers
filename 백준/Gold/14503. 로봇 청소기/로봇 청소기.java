
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {-1, 0, 1, 0};
	
	static class Position{
		int x;
		int y;
		Position(int x, int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	
	static int[][] map;
	static int cnt = 1;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(r, c, d);
		
		System.out.println(cnt);
	}
	
	
	
	
	
	
	static void clean(int x, int y, int d) {
		
		map[x][y] = 2;
		
		for (int i = 0; i <4; i++) {
			
			d = (d+3) % 4;
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx >= 0 && ny >= 0 && nx < N && ny <M) {
				if (map[nx][ny] == 0) {
					map[nx][ny] = 2;
					cnt++;
					clean(nx, ny, d);
					return;
					
				}
			}
		}


		int back =(d+2)%4;
		int bx = x + dx[back];
		int by = y + dy[back];
			
		if (bx >= 0 && by >= 0 && bx < N && by < M && map[bx][by] != 1) {
				clean(bx, by, d); 
		}
	}
		
}