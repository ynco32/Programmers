
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// LIS 이분탐색 풀이로 풀어야 함
public class Main {
	static int[] memo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new int[N + 1];
		int ans = 0;
		int[] num = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if (num[i] > memo[ans]) {
				ans++;
				memo[ans] = num[i];
			}
			else {
				idx = binarySearch(0, ans, num[i]);
				memo[idx] = num[i];
			}
			
			
		}
		System.out.println(ans);

	}

	public static int binarySearch(int left, int right, int key) {
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (memo[mid] < key) {
				left = mid + 1;
			} else {
				right = mid;
			}

		}

		return right;
	}
}
