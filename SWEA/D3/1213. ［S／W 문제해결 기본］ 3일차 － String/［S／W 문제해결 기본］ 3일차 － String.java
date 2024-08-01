import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t<=10; t++) {
			int count = 0;
			int tc = Integer.parseInt(br.readLine());
			
			String cmp = br.readLine();
			String data = br.readLine();
			
			for (int i = 0; i < data.length()-cmp.length()+1; i++) {
				boolean flag = true;
				for (int j = 0; j < cmp.length(); j++) {
					if (data.charAt(i+j) != cmp.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag) count++;
			}
			
			System.out.println("#" + t+ " " + count);
		}
	}
}
