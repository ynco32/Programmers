import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] dp = new int[str.length() + 1];
        dp[0] = 1;

        for (int i = 1; i <= str.length(); i++) {
            int now = str.charAt(i - 1) - '0';
            if (now >= 1 && now <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= 1000000;
            }

            if (i == 1) continue;

            int prev = str.charAt(i - 2) - '0';

            if (prev == 0) continue; 

            int value = prev * 10 + now;

            if (value >= 10 && value <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= 1000000;
            }
        }
        System.out.println(dp[str.length()]);
    }

}