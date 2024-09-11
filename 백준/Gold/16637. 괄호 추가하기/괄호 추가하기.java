
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, ans;
	static int[] store, number;
	static char[] operator;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		store = new int[N / 2];
		number = new int[N / 2 + 1];
		operator = new char[N / 2 + 1];
		ans = Integer.MIN_VALUE;

		String in = br.readLine();
		number[0] = in.charAt(0) - '0';
		int idx = 1;
		for (int i = 1; i < N; i += 2) {
			operator[idx] = in.charAt(i);
			number[idx] = in.charAt(i + 1) - '0';
			idx++;
		}

//		System.out.println(Arrays.toString(number));
//		System.out.println(Arrays.toString(operator));

		for (int i = 1; i <= N / 2; i++) {
			comb(0, 1, i);
		}
		if (N == 1) ans = number[0];
		System.out.println(ans);
	}

	static void comb(int cnt, int target, int total) {
		if (cnt == total) {
//			System.out.println(Arrays.toString(store));
			boolean[] op = new boolean[N / 2 + 1];
			int[] result = new int[N / 2 + 1];
			Arrays.fill(result, Integer.MIN_VALUE);

			for (int i = 0; i < total; i++) {
				op[store[i]] = true;
//				System.out.println(number[store[i] - 1] + " " + number[store[i]]);
				int temp = cal(number[store[i] - 1], number[store[i]], operator[store[i]]);
//				System.out.println(temp);
				result[store[i]] = temp;
				result[store[i] - 1] = temp;
			}

			for (int i = 0; i <= N / 2; i++) {
				if (result[i] == Integer.MIN_VALUE)
					result[i] = number[i];
			}

			for (int i = 1; i <= N / 2; i++) {
				if (!op[i]) {
					result[i] = cal(result[i - 1], result[i], operator[i]);
				}

				else {
					result[i] = result[i - 1];
				}

			}

//			System.out.println(result[N / 2]);
			ans = Math.max(ans, result[N / 2]);
			return;
		}

		for (int i = target; i <= N / 2; i++) {
			store[cnt] = i;
			comb(cnt + 1, i + 2, total);
		}

	}

	static int cal(int a, int b, char c) {
		if (c == '+')
			return a + b;
		else if (c == '*')
			return a * b;
		else if (c == '-')
			return a - b;

		return Integer.MIN_VALUE;
	}

}
