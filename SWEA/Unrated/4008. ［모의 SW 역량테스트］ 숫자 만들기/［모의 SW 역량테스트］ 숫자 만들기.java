
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[] nums;
	static int[] operators = new int[4];
	static int[] oper;
	static int maxResult, minResult;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine().trim());
			nums = new int[N];
			oper = new int[N - 1];
			maxResult = Integer.MIN_VALUE;
			minResult = Integer.MAX_VALUE;
			visited = new boolean[N - 1];

			StringTokenizer st = new StringTokenizer(br.readLine());

			operators[0] = Integer.parseInt(st.nextToken());
			operators[1] = Integer.parseInt(st.nextToken());
			operators[2] = Integer.parseInt(st.nextToken());
			operators[3] = Integer.parseInt(st.nextToken());

			// 0 : + | 1 : - | 2 : * | 3 : /

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			perm(0);

			sb.append("#").append(t).append(" ").append(maxResult - minResult).append("\n");
		}
		System.out.println(sb);
	}

	static void perm(int cnt) {
		if (cnt == N - 1) {
//			System.out.println(Arrays.toString(oper));
			int temp = calc();
//			System.out.println(temp);

			maxResult = Math.max(maxResult, temp);
			minResult = Math.min(minResult, temp);

			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operators[i] == 0)
				continue;
			oper[cnt] = i;
			operators[i]--;
			perm(cnt + 1);
			operators[i]++;

		}

	}

	static int calc() {
		int result = nums[0];

		for (int i = 0; i < N - 1; i++) {
			if (oper[i] == 0) {
				result += nums[i + 1];
			} else if (oper[i] == 1) {
				result -= nums[i + 1];
			} else if (oper[i] == 2) {
				result *= nums[i + 1];
			} else if (oper[i] == 3) {
				result /= nums[i + 1];
			}
		}

		return result;
	}

}
