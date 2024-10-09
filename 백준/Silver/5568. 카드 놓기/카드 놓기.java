
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	static int[] nums;
	static int[] store;
	static ArrayList<String> list;
	static boolean[] visited;
	static int N, K, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		nums = new int[N];
		store = new int[K];
		visited = new boolean[N];
		list = new ArrayList<>();
		ans = 0;

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		perm(0);
		System.out.println(ans);
	}

	private static void perm(int cnt) {
		if (cnt == K) {
			String temp = "";

			for (int i = 0; i < K; i++) {
				temp += Integer.toString(store[i]);
			}

			if (!list.contains(temp)) {
				list.add(temp);
				ans++;
			}

			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				store[cnt] = nums[i];
				perm(cnt + 1);
				visited[i] = false;
			}
		}

	}
}
