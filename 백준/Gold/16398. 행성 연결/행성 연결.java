import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[N][N];
		int[] minEdge = new int[N];
		boolean[] visited = new boolean[N];
		Arrays.fill(minEdge, Integer.MAX_VALUE);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		minEdge[0] = 0;
		int cnt = 0;
		long cost = 0;
		int i = 0;
		for (i = 0; i < N; i++) {

			int minVertex = -1;
			int minVal = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if (visited[j])
					continue;

				if (minVal > minEdge[j]) {
					minVertex = j;
					minVal = minEdge[j];
				}
			}

			if (minVertex == -1)
				break;

			visited[minVertex] = true;
			cost += minVal;

			for (int j = 0; j < N; j++) {
				if (!visited[j] && adjMatrix[minVertex][j] != 0 && minEdge[j] > adjMatrix[minVertex][j]) {
					minEdge[j] = adjMatrix[minVertex][j];
				}
			}

		}

		System.out.println(i == N ? cost : -1);

	}
}
