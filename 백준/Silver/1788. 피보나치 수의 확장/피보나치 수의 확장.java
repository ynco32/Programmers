import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int absN = Math.abs(n);
		long[] dp = new long[1000001];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= absN; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
		}

		dp[absN] %= 1000000000;

		if (n < 0) {
			if (absN % 2 == 0)
				System.out.println("-1");
			else
				System.out.println("1");
		} else if (n == 0) {
			System.out.println("0");
		} else {
			System.out.println("1");
		}
		System.out.println(dp[absN]);

	}
}
