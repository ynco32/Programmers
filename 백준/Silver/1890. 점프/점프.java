import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int list[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long dp[][] = new long[n][n];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int next = list[i][j];
                if (next == 0) break;

                if (j + next < n) dp[i][j + next] += dp[i][j];
                if (i + next < n) dp[i + next][j] += dp[i][j];
            }


        }
        System.out.println(dp[n - 1][n - 1]);
    }


}