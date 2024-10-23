
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Schedule implements Comparable<Schedule> {
		int date, pay;

		public Schedule(int date, int pay) {
			super();
			this.date = date;
			this.pay = pay;
		}

		@Override
		public String toString() {
			return "Schedule [date=" + date + ", pay=" + pay + "]";
		}

		@Override
		public int compareTo(Schedule o) {
			if (o.pay == this.pay) {
				return o.date - this.date;
			}
			return o.pay - this.pay;
		}

	}

	public static void main(String[] args) throws Exception {
		ArrayList<Schedule> list = new ArrayList<>();
		boolean[] visited = new boolean[10001];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.add(new Schedule(b, a));
		}
		
		Collections.sort(list);
		int ans = 0;
		for (Schedule s : list) {
			while (s.date > 0) {
				if (!visited[s.date]) {
					ans+= s.pay;
					visited[s.date] = true;
					break;
				}
				else {
					s.date--;
				}
			}
		}

		System.out.println(ans);
	}

}
