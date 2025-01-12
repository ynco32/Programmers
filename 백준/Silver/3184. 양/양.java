import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static char[][] map;
    static boolean[][] visited;
    static int sheep, wolf;
    static int R, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '#') {
                    visited[i][j] = true;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(sheep + " " + wolf);
    }

    static void bfs(int r, int c) {
        int s = 0;  // 영역 내 양 수
        int w = 0;  // 영역 내 늑대 수
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;
        // 시작 위치에 늑대 혹은 양이 있는지 확인
        if (map[r][c] == 'o') {
            s++;
        } else if (map[r][c] == 'v') {
            w++;
        }

        while (!q.isEmpty()) {
            int[] v = q.poll();
            for (int k = 0; k < 4; k++) {
                int nr = v[0] + dr[k];
                int nc = v[1] + dc[k];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc])
                    continue;

                if (map[nr][nc] == 'o') {
                    s++;
                } else if (map[nr][nc] == 'v') {
                    w++;
                }
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});

            }
        }

        if (s <= w) {
            wolf += w;
        } else {
            sheep += s;
        }
    }


}