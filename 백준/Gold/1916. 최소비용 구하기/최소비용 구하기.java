import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st;
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());


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

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[v + 1];
        int[] dist = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curEnd = cur.idx;

            if (!visited[curEnd]) {
                visited[curEnd] = true;

                for (Node n : graph.get(curEnd)) {
                    if (!visited[n.idx] && dist[n.idx] > dist[curEnd] + n.cost) {
                        dist[n.idx] = dist[curEnd] + n.cost;
                        pq.offer(new Node(n.idx, dist[n.idx]));
                    }
                }
            }
        }

        System.out.println(dist[end]);
    }
}