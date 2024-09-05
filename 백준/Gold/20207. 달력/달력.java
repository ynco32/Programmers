import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		int arr[] = new int[367];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			int from=stoi(st.nextToken());
			int to=stoi(st.nextToken());
			for(int day=from; day<=to; day++) {
				arr[day]++;
			}
		}
		int row=0;
		int col=0;
		int result=0;
		for(int i=1;i<367;i++) {
			if(arr[i]>0) {
				col++;
				row=Math.max(row, arr[i]);
			}else if(arr[i]==0) {
				result += (col*row);
				col=0;
				row=0;
			}
			
		}
		System.out.println(result);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
