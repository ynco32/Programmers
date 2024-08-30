
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] nums;
	static int[] selected = new int[3];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		long[] sum = new long[N * (N + 1) / 2 ];
		int index = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				sum[index++] = (nums[i] + nums[j]);
			}
		}

		Arrays.sort(sum);

		int max = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int target = nums[i] - nums[j];
				if (Arrays.binarySearch(sum, target) > -1) {
					max = Math.max(max, nums[i]);
				}
			}
		}
		System.out.println(max);
	}

}
