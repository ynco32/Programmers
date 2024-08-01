import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		sc.nextLine();
		for (int t = 1; t <= tc; t++) {
			String data = sc.nextLine();
			int result = 1;
			for (int i = 0; i < data.length()/2; i++) {
				if (data.charAt(i) != data.charAt(data.length()-i-1)) {
					result = 0;
				}
			}
			
			System.out.println("#" + t + " " + result);
			
		}
	}
}
