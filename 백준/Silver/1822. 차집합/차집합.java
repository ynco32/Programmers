import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int na = Integer.parseInt(st.nextToken());
		int nb = Integer.parseInt(st.nextToken());
		int[] A = new int[na];
		boolean[] check = new boolean[na];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < na; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);

		int cnt = 0;
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < nb; i++) {
			int start = 0;
			int end = na - 1;
			int temp = Integer.parseInt(st.nextToken());

			if (A[start] > temp || A[end] < temp)
				continue;

			while (start <= end) {
				int mid = (start + end) / 2;
				if (temp == A[mid]) {
					check[mid] = true;
					cnt++;
					break;
				} else if (A[mid] < temp) {
					start = mid + 1;
				} else if (A[mid] > temp) {
					end = mid - 1;
				}
			}
		}

		if (cnt == na) {
			System.out.println(0);
		}

		else {
			System.out.println(na - cnt);
			for (int i = 0; i < na; i++) {
				if (!check[i]) {
					System.out.print(A[i] + " ");
				}
			}
		}
	}
}