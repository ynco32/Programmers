import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];
            int[] row = new int[N];
            int[] col = new int[N];
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            int cnt = 0;
 
            // -- >
            for (int i = 0; i < N; i++) {
                boolean[] avail = new boolean[N];
 
                boolean flag = true;
                for (int j = 0; j < N; j++) {
 
                    if (j == N - 1) {
                        break;
                    }
 
                    if (map[i][j] == map[i][j + 1] + 1) {
                        if (X > N - j - 1) {
                            flag = false;
                            break;
                        }
 
                        for (int k = j + 1; k <= j + X; k++) {
                            if (map[i][k] == map[i][j] - 1) {
                                if (!avail[k])
                                    avail[k] = true;
                                else {
                                    flag = false;
                                    break;
                                }
                            } else {
                                flag = false;
                                break;
                            }
                        }
                    }
 
                    else if (map[i][j] == map[i][j + 1] - 1) {
                        if (X - 1 > j) {
                            flag = false;
                            break;
                        }
 
                        for (int k = j; k > j - X; k--) {
                            if (!avail[k])
                                avail[k] = true;
                            else {
                                flag = false;
                                break;
                            }
                        }
 
                    }
 
                    else if (map[i][j] == map[i][j + 1])
                        continue;
 
                    else {
                        flag = false;
                        break;
                    }
                }
 
                if (flag)
                    cnt++;
            }
 
 
            for (int i = 0; i < N; i++) {
                boolean[] avail = new boolean[N];
                boolean flag = true;
                for (int j = 0; j < N; j++) {
                    if (j == N - 1) {
                        break;
                    }
 
                    if (map[j][i] == map[j + 1][i] + 1) {
                        if (X > N - j - 1) {
                            flag = false;
                            break;
                        }
 
                        for (int k = j + 1; k <= j + X; k++) {
                            if (map[k][i] == map[j][i] - 1) {
                                if (!avail[k])
                                    avail[k] = true;
                                else {
                                    flag = false;
                                    break;
                                }
                            } else {
                                flag = false;
                                break;
                            }
                        }
                    }
 
                    else if (map[j][i] == map[j + 1][i] - 1) {
                        if (X - 1 > j) {
                            flag = false;
                            break;
                        }
 
                        for (int k = j; k > j - X; k--) {
                            if (!avail[k])
                                avail[k] = true;
                            else {
                                flag = false;
                                break;
                            }
                        }
 
                    }
 
                    else if (map[j][i] == map[j + 1][i])
                        continue;
 
                    else {
                        flag = false;
                        break;
                    }
                }
 
                if (flag)
                    cnt++;
            }
        System.out.println(cnt);
    }
 
}