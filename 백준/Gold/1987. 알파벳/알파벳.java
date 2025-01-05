import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static int[][] map;
    static boolean[] isVisited;
    static int ans = 0;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        isVisited = new boolean[26];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j) - 'A';
            }
        }
        isVisited[map[0][0]] = true; // 시작 위치 방문 처리
        dfs(0, 0, 1); // 시작 위치 포함하므로 cnt를 1로 시작
        System.out.println(ans);
    }

    static void dfs(int x, int y, int cnt) {
        ans = Math.max(ans, cnt);
        for (int i = 0; i < 4; i++) {
            int nr = x + dr[i];
            int nc = y + dc[i];
            if (nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
            if (!isVisited[map[nr][nc]]) { // 방문하지 않은 알파벳일 경우
                isVisited[map[nr][nc]] = true;
                dfs(nr, nc, cnt + 1);
                isVisited[map[nr][nc]] = false; // 백트래킹
            }
        }
    }
}
