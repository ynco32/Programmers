import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[] num = new int[9];
		int N = 9;
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
			sum+= num[i];
		}
		
		int flagA = -1;
		int flagB = -1;
		
		
		for (int j = 0; j < N; j++) {
			for (int i = 1; i < N; i++) {
			
				if((sum-num[j]-num[i]) == 100 && (i !=j)) {
					flagA=i;
					flagB=j;
					break;
				}
			}
		}
		
		num[flagA]=-1;
		num[flagB]=-1;
		
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if (num[i] > num[j]) {
					int temp = num[j];
					num[j] = num[i];
					num[i] = temp;
				}
			}
		}

		
		
		for (int i =2; i < N; i++) {
			System.out.println(num[i]);
		}
	}
}
