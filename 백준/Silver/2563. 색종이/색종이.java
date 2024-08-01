import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		boolean[][] white = new boolean[101][101];
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				white[i][j] = false;
			}
		}
		
		int cnt = 0;
		
		for (int k = 0 ; k < N; k++) {
			int col = sc.nextInt();
			int row = sc.nextInt();
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (white[row+i][j+col] == false) {
						white[row+i][j+col] = true;
						cnt++;
					}
				}
			}			
		}
		System.out.println(cnt);
	}
	

}
