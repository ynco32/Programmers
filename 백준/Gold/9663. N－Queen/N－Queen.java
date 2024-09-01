import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] col;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = 0;
		col = new int[N + 1];
		setQueens(1);
		System.out.println(ans);

	}

	static void setQueens(int rowNo) {

		if (!isAvailable(rowNo - 1))
			return;

		if (rowNo > N) {
			ans++;
			return;
		}

		for (int c = 1; c <= N; c++) {
			col[rowNo] = c;
			setQueens(rowNo + 1);
		}
	}

	static boolean isAvailable(int rowNo) {
		for (int k = 1; k < rowNo; k++) {
			if (col[rowNo] == col[k] || rowNo - k == Math.abs(col[rowNo] - col[k]))
				return false;
		}

		return true;

	}
}
