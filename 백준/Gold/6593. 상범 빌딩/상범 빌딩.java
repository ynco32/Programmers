import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {1, -1, 0, 0, 0, 0};
    static int[] dc = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                return;
            }

            char[][][] building = new char[L][R][C];
            boolean[][][] visited = new boolean[L][R][C];

            Queue<int[]> q = new LinkedList<>();

            for (int i = 0; i < L; i++) {

                for (int r = 0; r < R; r++) {
                    String temp = br.readLine();
                    for (int c = 0; c < C; c++) {
                        building[i][r][c] = temp.charAt(c);
                        if (building[i][r][c] == 'S') {
                            q.offer(new int[]{i, r, c, 0});
                            visited[i][r][c] = true;
                        }
                    }
                }

                br.readLine();
            }

            int ans = -1;
            while (!q.isEmpty()) {
                int[] current = q.poll();

                for (int d = 0; d < 6; d++) {
                    int nh = current[0] + dh[d];
                    int nr = current[1] + dr[d];
                    int nc = current[2] + dc[d];

                    if (nh < 0 || nh >= L || nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nh][nr][nc]) continue;

                    if (building[nh][nr][nc] == 'E') {
                        ans = current[3] + 1;
                        break;
                    }

                    if (building[nh][nr][nc] == '.') {
                        q.offer(new int[]{nh, nr, nc, current[3] + 1});
                        visited[nh][nr][nc] = true;
                    }
                }

            }

            if (ans == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + ans + " minute(s).");
            }

        }
    }
}