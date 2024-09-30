
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp0 = new long[N+1];
		long[] dp1 = new long[N+1];
		
		dp1[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp1[i] = dp0[i-1];
			dp0[i] = dp0[i-1] + dp1[i-1];
		}
		
		System.out.println(dp0[N] + dp1[N]);
	}
}
