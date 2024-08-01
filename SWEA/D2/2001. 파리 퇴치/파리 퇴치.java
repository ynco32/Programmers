import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] data = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					data[i][j] = sc.nextInt();
				}
			}
			
			int sum = 0;
			for (int k = 0; k <= N-M; k++) {
				for (int l = 0; l <= N-M; l++) {
					int tempSum = 0;
					for (int i = k; i < k+M; i++) {
						for (int j = l; j < l+M; j++) {
							tempSum += data[i][j];
						}
					}
					
					sum = Math.max(sum, tempSum);
					
				}
			}
			System.out.println("#" + t + " " + sum);
			
			
		}
	}
}
