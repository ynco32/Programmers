import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] liquid = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(liquid);
		int si = 0;
		int li = N - 1;

		int ansS = si;
		int ansL = li;

		long res = Long.MAX_VALUE;

		while (si < li) {
			long cur = liquid[si] + liquid[li];

			if (Math.abs(cur) < res) {
				ansS = si;
				ansL = li;
				res = Math.abs(cur);
			}

			if (cur == 0) {
				break;
			}

			else if (cur < 0) {
				si++;
			} else if (cur > 0) {
				li--;
			}

		}

		System.out.println(liquid[ansS] + " " + liquid[ansL]);
	}

}
