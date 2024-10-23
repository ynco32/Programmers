import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// Dynamic Programming
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 길이 1이면 무조건 팰린드롬
		boolean[][] dp = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			dp[i][i] = true;
		}

		// 길이 2일때 앞-뒤 같으면 팰린드롬
		for (int i = 0; i < N-1; i++) {
			if (arr[i] == arr[i + 1]) {
				dp[i][i + 1] = true;
			}

		}

		for (int i = 2; i < N; i++) {
			for (int j = 0; j < N - i; j++) {
				if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1]) {
					dp[j][j + i] = true;
				}

			}
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			if (dp[s][e])
				sb.append("1");
			else
				sb.append("0");

			sb.append("\n");
		}

		System.out.println(sb);
	}

}
