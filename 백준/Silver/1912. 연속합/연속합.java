
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[N];
		int[] dp = new int[N + 1];

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int ans = Integer.MIN_VALUE;
		for (int i = N - 1; i >= 0; i--) {

			dp[i] = num[i] + dp[i + 1];
			ans = Math.max(ans, dp[i]);
			if (num[i] + dp[i + 1] < 0)
				dp[i] = 0;

		}
		System.out.println(ans);

	}
}
