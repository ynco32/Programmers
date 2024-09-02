
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		boolean[] time = new boolean[N * L + (N - 1) * 5 + 1];

		for (int idx = 0; idx < N; idx++) {
			for (int i = 0; i < L; i++) {
				time[i + idx * (L + 5)] = true;
			}
		}

		int ans;
		for (ans = 0; ans < time.length; ans += D) {
			if (!time[ans]) {
				break;
			}
		}

		System.out.println(ans);
	}
}
