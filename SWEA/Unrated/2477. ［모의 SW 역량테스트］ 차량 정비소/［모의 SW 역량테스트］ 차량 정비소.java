
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static class Customer implements Comparable<Customer> {
		int no;
		int arrivalTime;
		int receptionDoneTime;
		int receptionNo;
		int repairNo;

		@Override
		public int compareTo(Customer o) {
			if (this.receptionDoneTime == o.receptionDoneTime) {
				return this.receptionNo - o.receptionNo;
			}
			return this.receptionDoneTime - o.receptionDoneTime;
		}

		@Override
		public String toString() {
			return "Customer [no=" + no + ", arrivalTime=" + arrivalTime + ", receptionDoneTime=" + receptionDoneTime
					+ ", receptionNo=" + receptionNo + ", repairNo=" + repairNo + "]";
		}

	}

	static List<Customer> customers = new ArrayList<>();
	static int[] reception, repair, a, b;
	static PriorityQueue<Customer> pq = new PriorityQueue<>();
	static int N, M, K, A, B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			reception = new int[N];
			a = new int[N];
			repair = new int[M];
			b = new int[M];

			pq.clear();
			customers.clear();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				int time = Integer.parseInt(st.nextToken());
				Customer c = new Customer();
				c.arrivalTime = time;
				c.no = i + 1;
				customers.add(c);
			}

			for (Customer customer : customers) {
				int minTime = Integer.MAX_VALUE;
				int minReception = 0;

				for (int i = 0; i < N; i++) {
					if (reception[i] <= customer.arrivalTime) {
						customer.receptionNo = i + 1;
						customer.receptionDoneTime = customer.arrivalTime + a[i];
						reception[i] = customer.receptionDoneTime;
						pq.offer(customer);
						break;
					}

					else {
						if (reception[i] < minTime) {
							minTime = reception[i];
							minReception = i;
						}
					}

					if (i == N - 1) {
						customer.receptionDoneTime = reception[minReception] + a[minReception];
						customer.receptionNo = minReception + 1;
						reception[minReception] = customer.receptionDoneTime;
						pq.offer(customer);
					}

				}

//				System.out.println(Arrays.toString(reception));
			}

			int ans = 0;
			while (!pq.isEmpty()) {
				Customer customer = pq.poll();

				int minTime = Integer.MAX_VALUE;
				int minRepair = 0;

				for (int i = 0; i < M; i++) {
					if (repair[i] <= customer.receptionDoneTime) {
						customer.repairNo = i + 1;
						repair[i] = customer.receptionDoneTime + b[i];
						break;
					}

					else {
						if (repair[i] < minTime) {
							minTime = repair[i];
							minRepair = i;
						}
					}

					if (i == M - 1) {
						customer.repairNo = minRepair + 1;
						repair[minRepair] = repair[minRepair] + b[minRepair];
					}
				}

				if (customer.receptionNo == A && customer.repairNo == B) {
					ans += customer.no;
				}

//				System.out.println(Arrays.toString(repair));
			}

//			System.out.println(customers);
			if (ans == 0)
				ans = -1;
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
