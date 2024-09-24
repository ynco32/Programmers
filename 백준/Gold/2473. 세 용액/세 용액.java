import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static long[] store = new long[3];
	static long[] input;
	static int N;
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = new long[N];

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);

		ans = 3000000000L;

		for (int i = 1; i < N; i++) {
			int idx1 = 0;
			int idx2 = N - 1;

			while (idx1 < i && idx2 > i) {

				long temp = input[idx1] + input[idx2] + input[i];

				if (Math.abs(temp) < ans) {
					store[0] = input[idx1];
					store[1] = input[i];
					store[2] = input[idx2];
					ans = Math.abs(temp);
				}

				if (temp < 0) {
					idx1++;
				}

				else if (temp > 0) {
					idx2--;
				}

				else
					break;
			}
		}

//		System.out.println(ans);
		System.out.println(store[0] + " " + store[1] + " " + store[2]);

	}

}
