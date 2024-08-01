
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {

			int[][] data = new int[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					data[i][j] = sc.nextInt();
				}
			}

			int result = 1;

			for (int i = 0; i < 9; i++) {
				boolean[] isExist = new boolean[10];
				boolean[] isExist2 = new boolean[10];
				for (int j = 0; j < 9; j++) {
					if (!isExist[data[i][j]])
						isExist[data[i][j]] = true;
					else {
						result = 0;
						break;
					}
					if (!isExist2[data[j][i]])
						isExist2[data[j][i]] = true;
					else {
						result = 0;
						break;
					}
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					boolean[] isExist3 = new boolean[10];

					for (int l = i * 3; l < i * 3 + 3; l++) {
						for (int k = j * 3; k < j * 3 + 3; k++) {
							if (!isExist3[data[l][k]])
								isExist3[data[l][k]] = true;
							else {
								result = 0;
								break;
							}
						}
					}
				}
			}

			System.out.println("#" + t + " " + result);
		}
	}
}
