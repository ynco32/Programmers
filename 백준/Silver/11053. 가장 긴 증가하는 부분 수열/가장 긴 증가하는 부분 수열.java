
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
 6
10 20 10 30 20 50
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] best = new int[N];
		int[] prev = new int[N];
		int[] num = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			prev[i] = i;
			best[i] = 1;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (num[i] > num[j] && best[i] < best[j]+1) {
					best[i] = best[j] + 1;
					prev[i] = j;
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, best[i]);
		}

		System.out.println(ans);
	}
}
