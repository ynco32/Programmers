import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		int N = data.length();
		
		int R = (int) Math.sqrt(N);
		int C = 0;
		
		while (R > 0) {
			if (N % R == 0) {
				C = N/R;
				break;
			}
			
			else { R--; }
		}
		
		if (C==0) {
			C = N;
			R = 1;
		}
		
		
		String[] code = new String[R];
		for (int i = 0; i < R; i++) {
			String line = "";
			for (int j = 0; j < C; j++) {
				line += data.charAt(j*R+i);
			}
			code[i] = line;
		}
		
		for(int i = 0; i < R; i++) {
			System.out.print(code[i]);
		}
	}
}
