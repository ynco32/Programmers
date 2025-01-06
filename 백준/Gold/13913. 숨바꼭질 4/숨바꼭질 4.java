import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] time; // 방문 시간 및 단계
    static int[] isVisited; // 경로 추적 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        time = new int[100001];
        isVisited = new int[100001];

        if (N == K) {
            System.out.println(0);
            System.out.println(N);
            return;
        }

        bfs(N, K);

        // 경로 추적 및 출력
        StringBuilder sb = new StringBuilder();
        sb.append(time[K] - 1).append("\n");

        int idx = K;
        LinkedList<Integer> path = new LinkedList<>();
        while (idx != -1) {
            path.addFirst(idx);
            idx = isVisited[idx];
        }

        for (int loc : path) {
            sb.append(loc).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    static void bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        time[start] = 1; // 시작점 시간 초기화
        isVisited[start] = -1; // 시작점은 이전 노드가 없음

        while (!q.isEmpty()) {
            int loc = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = loc + 1; // +1 이동
                else if (i == 1) next = loc - 1; // -1 이동
                else next = loc * 2; // 순간이동

                if (next < 0 || next > 100000 || time[next] != 0) continue;

                q.add(next);
                time[next] = time[loc] + 1; // 시간 갱신
                isVisited[next] = loc; // 경로 추적

                if (next == target) return; // 목표 도달 시 조기 종료
            }
        }
    }
}
