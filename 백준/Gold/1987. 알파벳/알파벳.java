import java.io.*;
import java.util.*;

public class Main {
    static int R, C, answer = 0;
    static char[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static HashSet<Character> alphabet;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = input.charAt(j);
            }
        }
        alphabet = new HashSet<>(); // HashSet 초기화
        back(0, 0, 1); //
        System.out.println(answer);
    }
    static void back(int x, int y, int count) {
        answer = Math.max(answer, count);
        alphabet.add(graph[x][y]);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (!alphabet.contains(graph[nx][ny])) { // 처음 방문한 알파벳일 경우
                    back(nx, ny, count + 1);
                }
            }
        }
        alphabet.remove(graph[x][y]); // 이전 상태로 돌아가기 위해 제거
    }
}