
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, in[];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 간선의 수
		in = new int[N + 1]; // 진입 차수 배열, 각 노드의 진입 차수를 기록

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			in[b]++;
		}

		topological();
		System.out.println(sb);

	}

	static void topological() {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (in[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");
			for (int i = 0; i < graph.get(current).size(); i++) {
				int next = graph.get(current).get(i);
				in[next]--;
				if (in[next] == 0) {
					queue.offer(next);
				}
			}
		}

	}
}
