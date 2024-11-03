import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<int[]> classes = new ArrayList<>();
		boolean[] check = new boolean[N];
		int[] newClass = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int[] cla = new int[2];
			cla[0] = Integer.parseInt(st.nextToken());
			cla[1] = Integer.parseInt(st.nextToken());
			classes.add(cla);
		}

        Collections.sort(classes, (l1, l2) -> l1[0] == l2[0] ? l1[1] - l2[1] : l1[0] - l2[0]);

		//Collections.sort(classes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
		
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(classes.get(0)[1]);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= classes.get(i)[0]) {
                pq.poll();
            }
            pq.offer(classes.get(i)[1]);
        }

        System.out.println(pq.size());

	}
}