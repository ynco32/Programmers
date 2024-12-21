import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int N, M;
    static char[][] map;
    static int[][] fireMap;
    static int[][] jMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            boolean flag = true;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            fireMap = new int[N][M];
            jMap = new int[N][M];

            Queue<int[]> fireQueue = new LinkedList<>();
            Queue<int[]> jQueue = new LinkedList<>();

            // Initialize maps
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = line.charAt(j);
                    fireMap[i][j] = Integer.MAX_VALUE;
                    jMap[i][j] = Integer.MAX_VALUE;

                    if (map[i][j] == '*') {
                        fireQueue.offer(new int[]{i, j});
                        fireMap[i][j] = 0;
                    } else if (map[i][j] == '@') {
                        jQueue.offer(new int[]{i, j});
                        jMap[i][j] = 0;
                    }
                }
            }

            // Spread fire BFS
            while (!fireQueue.isEmpty()) {
                int[] current = fireQueue.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = current[0] + dr[d];
                    int nc = current[1] + dc[d];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (map[nr][nc] == '#') continue;
                    if (fireMap[nr][nc] <= fireMap[current[0]][current[1]] + 1) continue;

                    fireMap[nr][nc] = fireMap[current[0]][current[1]] + 1;
                    fireQueue.offer(new int[]{nr, nc});
                }
            }

            // Character escape BFS
            while (!jQueue.isEmpty() && flag) {
                int[] current = jQueue.poll();

                // Check if we can escape at this point
                if (current[0] == 0 || current[0] == N - 1 || current[1] == 0 || current[1] == M - 1) {
                    System.out.println(jMap[current[0]][current[1]] + 1);
                    flag = false;
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = current[0] + dr[d];
                    int nc = current[1] + dc[d];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (map[nr][nc] == '#') continue;
                    if (jMap[nr][nc] <= jMap[current[0]][current[1]] + 1) continue;
                    if (fireMap[nr][nc] <= jMap[current[0]][current[1]] + 1) continue;

                    jMap[nr][nc] = jMap[current[0]][current[1]] + 1;
                    jQueue.offer(new int[]{nr, nc});
                }
            }

            if (flag)
                System.out.println("IMPOSSIBLE");

        }

    }
}