import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		boolean[][] white = new boolean[101][101];
		
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				white[i][j] = false;
			}
		}
		
		int cnt = 0;
		
		
		
		for (int k = 0; k<N; k++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			for (int i = row; i < row+10; i++) {
				for (int j = col; j < col+10; j++) {
					white[i][j] =true;
				}
			}
			
		}
		
		final int[] dx = {1, -1, 0, 0};
		final int[] dy = {0, 0, -1, 1};
		
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				
				if (white[i][j]) {
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (nx < 0 || ny < 0 || nx >= 100 || ny >= 100 || !white[nx][ny]) {
                            cnt++;
                        }
					}
					
					
				}
				
			}
		}
		
		System.out.println(cnt);
	}
	
}