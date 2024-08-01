

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("data/input_1216.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			
//			char[][] data = new char[101][101];
			String[] data = new String[101];
			
			for (int i = 1; i <= 100; i++) {
				String temp = br.readLine();
				for (int j = 1; j <= 100; j++) {
					data[i] = temp;
					//data[i][j] = temp.charAt(j-1);
					//System.out.println(temp.charAt(j-1));
					//System.out.println(data[i][j]);
				}
			}
			
			//System.out.println(Arrays.deepToString(data));
			
			//가로줄
			int max = Integer.MIN_VALUE;
			for (int r = 1; r <= 100; r++) {
				
				int[][] tempSum = new int[101][101];
				
				
				for (int i = 0; i <= 100; i++) {
					tempSum[0][i] = 0;
					tempSum[i][0] = 0;
				}
				
				
				int tempMax = 0;
				for (int i = 1; i <= 100; i++) {
					StringBuffer sb = new StringBuffer(data[r]);
					String newData = sb.reverse().toString();
					
					for (int j = 1; j <= 100; j++) {
						if (data[r].charAt(i-1) == newData.charAt(j-1)) {
							tempSum[i][j] = tempSum[i-1][j-1]+1;
							tempMax = Math.max(tempMax, tempSum[i][j]);
						}
						else tempSum[i][j] = 0;
						max = Math.max(max, tempMax);
					}
				}
			}
			
			
			//세로줄
			int max2 = Integer.MIN_VALUE;
			for (int c = 1; c <= 100; c++) {
				
				int[][] tempSum = new int[101][101];
				
				
				for (int i = 0; i <= 100; i++) {
					tempSum[0][i] = 0;
					tempSum[i][0] = 0;
				}
				
				String dataV = "";
				for (int i = 0; i < 100; i++) {
					dataV += data[i+1].charAt(c-1);
					
				}
				
				
				int tempMax = 0;
				for (int i = 1; i <= 100; i++) {
					StringBuffer sb = new StringBuffer(dataV);
					String newData = sb.reverse().toString();
					
					for (int j = 1; j <= 100; j++) {
						if (dataV.charAt(i-1) == newData.charAt(j-1)) {
							tempSum[i][j] = tempSum[i-1][j-1]+1;
							tempMax = Math.max(tempMax, tempSum[i][j]);
						}
						else tempSum[i][j] = 0;
						max2 = Math.max(max2, tempMax);
					}
				}
			}
			
			
			
			System.out.println("#" + tc + " " + Math.max(max,max2));

		}
		
	}
}
