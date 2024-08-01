import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] childA = new int[5];
		int[] childB = new int[5];
		
		for (int n =0; n< N; n++) {
			int a = sc.nextInt();
			for (int i = 0; i < a; i++) {
				int idxA = sc.nextInt();
				childA[idxA]++;
			}
			int b = sc.nextInt();
			for (int i = 0; i < b; i++) {
				int idxB = sc.nextInt();
				childB[idxB]++;
			}
			int j = 4;
			for (j = 4; j >= 1; j--) {
				if (childA[j] > childB[j]) {
					System.out.println("A");
					break;
				}
				
				else if (childA[j] < childB[j]) {
					System.out.println("B");
					break;
				}
				
				else continue;

			}
			
			if (j==0) System.out.println("D");
			
			for (int i = 0; i <5; i++) {
				childA[i] = 0;
				childB[i] = 0;
			}
		}
		
	}
}
