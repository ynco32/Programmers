
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int cnt = 1;
//		n--;
//		
//		while (n>0) {
//			n -= 6*cnt;
//			cnt++;
//		}
//		
//		int sum = 1;
//		while (sum < n) {
//			
//		}
//		System.out.println(cnt);
		
		Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long sum = 1;
        int i = 1;

        while (sum < n) {
            sum += i * 6;
            i++;
        }
        System.out.println(i);
	}
}
