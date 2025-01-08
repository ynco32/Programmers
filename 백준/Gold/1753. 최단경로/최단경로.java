import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        boolean[] visited = new boolean[v + 1];
        int[] dist = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        for (int i = 0; i <= v; i++) {
            int val = Integer.MAX_VALUE;
            int idx = 0;
            for (int j = 1; j <= v; j++) {
                if (!visited[j] && dist[j] < val) {
                    val = dist[j];
                    idx = j;
                }
            }

            visited[idx] = true;

            for (int j = 0; j < graph.get(idx).size(); j++) {
                Node adj = graph.get(idx).get(j);

                if (dist[adj.idx] > dist[idx] + adj.cost) {
                    dist[adj.idx] = dist[idx] + adj.cost;
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}