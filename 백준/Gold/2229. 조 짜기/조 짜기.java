import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], dp[j-1] + score(j,i,arr));
			}
		}
		System.out.println(dp[N]);
	}
	
	public static int score(int startIdx, int endIdx, int[] arr) {
		int maxVal = Integer.MIN_VALUE;
		int minVal = Integer.MAX_VALUE;
		for (int i = startIdx-1; i <= endIdx-1; i++) {
			maxVal = Math.max(arr[i], maxVal);
			minVal = Math.min(arr[i], minVal);
		}
		return maxVal - minVal;
	}
	
}
