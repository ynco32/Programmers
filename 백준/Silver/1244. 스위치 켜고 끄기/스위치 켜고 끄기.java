import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] bulbs = new int[N+1];
		for (int i =1; i < N+1; i++) {
			bulbs[i] = sc.nextInt();
		}
		
		int S = sc.nextInt();
		for (int i = 0; i < S; i++) {
			int s = sc.nextInt();
			int idx = sc.nextInt();
			
			if (s == 1) {
				for (int j = idx; j < N+1; j+= idx) {
					bulbs[j] = 1-bulbs[j];
				}
				
//				System.out.println("male");
//				for (int k = 1; k<=N; k++) {
//					System.out.print( bulbs[k]+" ");
//				}
			}
			
			
			else if (s == 2) {
				
				int j = 1;
				
				bulbs[idx] = 1-bulbs[idx];
				for (j = 1; idx > j &&  j <= N - idx; j++) {
					if (bulbs[idx-j] == bulbs[idx+j]) {
						bulbs[idx-j] = 1- bulbs[idx-j];
						bulbs[idx+j] = 1- bulbs[idx+j];
					}
					else break;
				
				}			
//				System.out.println("female");
//				System.out.println("j" + j);
//				for (int k = 1; k<=N; k++) {
//					System.out.print(bulbs[k]+" ");
//				}
			}
		}
		
//		System.out.println("result");
		for (int i = 1; i<=N; i++) {
			System.out.print(bulbs[i]+" ");
			if (i%20==0) { 
				//System.out.println();
				System.out.println();
			}
		}
		
	}
}
