import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int t= sc.nextInt();
			
			int[][] ladder = new int[100][100];
			int targetX = 0;
			int targetY = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j< 100; j++) {
					ladder[i][j] = sc.nextInt();
					
					if (ladder[i][j] == 2) {
						targetX = j;
						targetY = i;
					}
				}
			}
			
		
			while (targetY != 0) {
				if (targetX > 0 && ladder[targetY][targetX-1] == 1) {
					while (targetX > 0 && ladder[targetY][targetX-1] == 1) { targetX--; }
				}
				else if (targetX < 99 && ladder[targetY][targetX+1] == 1) {
					while (targetX <99 && ladder[targetY][targetX+1] == 1) { targetX++; }
				}
				targetY--;
			}
			
			
			System.out.println("#"+t+" " +targetX);
		}	
	}
}
