import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int t= 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] mapSum = new int[N+1][N+1];
			
			int sum = Integer.MIN_VALUE;
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N + 1; j++) {
					int temp = Integer.parseInt(st.nextToken());
					mapSum[i][j] = temp + mapSum[i - 1][j] + mapSum[i][j - 1] - mapSum[i - 1][j - 1];
				}
			}

			for (int i = M; i < N + 1; i++) {
				for (int j = M; j < N + 1; j++) {
					int tempSum = mapSum[i][j] - mapSum[i][j - M] - mapSum[i - M][j] + mapSum[i - M][j - M];
					if (tempSum > sum)
						sum = tempSum;
				}
			}
			
			System.out.println("#"+t + " " + sum);
			
		}
		
	}
}
