import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] matrix;
	static int[][] original;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		matrix = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken())%1000;

			}
		}

		int[][] ans = matrixPow(B);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}

	}

	static int[][] matrixPow(long b) {
		if (b == 1) {
			return matrix;
		}
		int[][] temp = matrixPow(b / 2);
		int[][] res = matrixMult(temp, temp);
		if (b % 2 == 0) {
			return res;
		}
		return matrixMult(res, matrix);
	}

	static int[][] matrixMult(int[][] a, int[][] b) {
		int[][] res = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int temp = 0;
				for (int k = 0; k < N; k++) {
					temp += a[i][k] * b[k][j];
					//res[i][j] = temp % 1000;
				}
				res[i][j] = (int) (temp % 1000);
			}
		}
		return res;
	}

}
