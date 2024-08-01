import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] student = new int[7][2];
		
		for (int n = 0; n<N;n++) {
			int s = sc.nextInt();
			int y = sc.nextInt();
			student[y][s]++;
		}
		
		int cnt = 0;
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j <2; j++) {
				if (student[i][j] % K > 0) {
					cnt += (1+student[i][j]/K);
				}
				else cnt += student[i][j]/K;
			}
		}
		
		System.out.println(cnt);
	}
}
