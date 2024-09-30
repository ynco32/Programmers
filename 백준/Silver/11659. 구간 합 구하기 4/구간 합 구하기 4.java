
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int num[] = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			num[i] = num[i - 1] + Integer.parseInt(st.nextToken());
		}

		for (int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			int ith = Integer.parseInt(st.nextToken());
			int jth = Integer.parseInt(st.nextToken());

			System.out.println(num[jth] - num[ith - 1]);

		}

	}
}
