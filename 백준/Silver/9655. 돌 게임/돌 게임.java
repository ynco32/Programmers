
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			if (i > 3 && dp[i - 3] > 0) {
				dp[i] = dp[i - 3] == 1 ? 2 : 1;
			} else {
				dp[i] = dp[i - 1] == 1 ? 2 : 1;
			}
		}
		
		if (dp[N] == 1) 
			System.out.println("SK");
		else 
			System.out.println("CY");
	}
}
