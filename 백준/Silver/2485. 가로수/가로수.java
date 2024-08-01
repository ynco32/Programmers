import java.util.Scanner;

public class Main {
	
	static int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] data = new int[N];
		data[0] = sc.nextInt();
		for (int i = 1; i < N; i++) {
			data[i] = sc.nextInt();
			data[i] -= data[0];
		}
		
		int len = data[N-1];
		int distance = gcd(data[1], data[2]);
		
		for (int i = 3; i < N; i++) {
			distance = gcd(data[i], distance);
		}
		
		int cnt = len / distance - N + 1;
		System.out.println(cnt);
		
	}
}
