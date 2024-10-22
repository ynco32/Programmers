
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Jewelry {
		int m, v;

		public Jewelry(int m, int v) {
			super();
			this.m = m;
			this.v = v;
		}

		@Override
		public String toString() {
			return "Jewelry [m=" + m + ", v=" + v + "]";
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<Jewelry> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			Jewelry jewelry = new Jewelry(m, v);
			list.add(jewelry);
		}

		Collections.sort(list, (o1, o2) -> o1.m - o2.m);

		int[] carry = new int[K];
		for (int i = 0; i < K; i++) {
			carry[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(carry);

		long ans = 0;
		int idx = 0;
		PriorityQueue<Jewelry> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);
		for (int i = 0; i < K; i++) {
			while (idx < N && list.get(idx).m <= carry[i]) {
				Jewelry j = list.get(idx++);
				pq.add(new Jewelry(j.m, j.v));
			}
			if (!pq.isEmpty())
				ans += pq.poll().v;
		}
		System.out.println(ans);
	}
}
