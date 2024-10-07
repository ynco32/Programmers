
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			int ans = 0;
			list.clear();
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] nums = new int[N];

			char[] temp = br.readLine().trim().toCharArray();

			for (int i = 0; i < N; i++) {

				if (temp[i] > '9') {
					nums[i] = temp[i] - 'A' + 10;
				} else {
					nums[i] = temp[i] - '0';
				}

			}

			int len = N / 4;
			for (int i = 0; i < len; i++) {
//				System.out.println(Arrays.toString(nums));
				for (int j = 0; j < 4; j++) {
					int pow = len - 1;
					int add = 0;

					for (int k = 0; k < len; k++) {
						int idx = k + len*j;
						add += nums[idx] * (int) Math.pow(16, pow);
						pow--;
					}
					if (!list.contains(add))
						list.add(add);
				}
				
//				System.out.println(list);

				int[] copy = new int[N];
				for (int c = 0; c < N; c++) {
					copy[i] = nums[i];
				}

				for (int c = 0; c < N; c++) {
					copy[c] = nums[c];
				}
				for (int c = 1; c < N; c++) {
					nums[c] = copy[c - 1];
				}
				nums[0] = copy[N - 1];

			}

			Collections.sort(list);
			

			ans = list.get(list.size() - K);

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);
	}
}
