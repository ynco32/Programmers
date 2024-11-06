
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N, X, M;
	static int list[][];
	static int ans;
	static int[] cage;
	static int[] res;
	static int maxH;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			list = new int[M][3];
			cage = new int[N];
			res = new int[N];
			ans = Integer.MIN_VALUE;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				list[m][0] = Integer.parseInt(st.nextToken());
				list[m][1] = Integer.parseInt(st.nextToken());
				list[m][2] = Integer.parseInt(st.nextToken());
			}
			maxH = -1;
			perm(0, 0);
			sb.append("#").append(t).append(" ");
			if (maxH == -1)
				sb.append("-1");
			else {
				for (int i = 0; i < N; i++) {
					sb.append(res[i]).append(" " );
				}
			}

			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void perm(int cnt, int totalH) {
		if (cnt == N) {
			
			if (maxH >= totalH) return; 
			
			boolean flag = true;
			for (int i = 0; i < M; i++) {
				int l = list[i][0] - 1;
				int r = list[i][1] - 1;
				int total = list[i][2];

				int hams = 0;
				for (int j = l; j <= r; j++) {
					hams += cage[j];
				}

				if (hams != total) {
					flag = false;
					break;
				}
			}

			if (flag) {
				maxH = totalH;
				for (int i = 0; i < N; i++) {
					res[i] = cage[i];
				}
			}

			return;
		}

		for (int i = 0; i <= X; i++) {
			cage[cnt] = i;
			perm(cnt + 1, totalH+i);
		}

	}

}
