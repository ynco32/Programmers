import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int[] dir = new int[6];
		int[] len = new int[6];
		int[] dir4 = new int[5];
		int xl=0;
		int idxV = 0;
		int yl = 0;
		int idxH = 0;
		for (int i = 0; i < 6; i++) {
			dir[i]=sc.nextInt(); 
			len[i]=sc.nextInt(); 
			dir4[dir[i]]++;
		}
		
		if (dir4[1] < dir4[2]) {
			for (int i = 0; i < 6; i++) {
				if (dir[i] == 1) {
					yl = len[i];
					idxV = i;
				}
			}
		}
		else {
			for (int i = 0; i < 6; i++) {
				if (dir[i] == 2) {
					yl = len[i];
					idxV = i;
				}
			}
		}
		if (dir4[3] < dir4[4]) {
			for (int i = 0; i < 6; i++) {
				if (dir[i] == 3) {
					xl = len[i];
					idxH = i;
				}
			}
		}
		else {
			for (int i = 0; i < 6; i++) {
				if (dir[i] == 4) {
					xl = len[i];
					idxH = i;
				}
			}
		}
		
		if (idxV < idxH) {
			idxV += 3;
			idxH += 3;
			if (idxV >= 6) idxV -=6;
			if (idxH >= 6) idxH -=6;
			
		}
		else {
			idxH += 3;
			idxV += 3;
			if (idxV >= 6) idxV -=6;
			if (idxH >= 6) idxH -=6;
		}
		
		
		int area = xl*yl - len[idxV]*len[idxH];
		
		System.out.println(area*K);
		
	}
}