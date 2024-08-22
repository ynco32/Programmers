
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int dayP, monthP, quaterP, yearP;
	static int min;
	static int[] plan = new int[12];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());

			dayP = Integer.parseInt(st.nextToken());
			monthP = Integer.parseInt(st.nextToken());
			quaterP = Integer.parseInt(st.nextToken());
			yearP = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int startM = 0;
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			min = yearP;
			cal(startM, 0);

			System.out.println("#" + t + " " + min);
		}

	}

	static void cal(int month, int current) {

		if (current >= min) {
			return;
		}

		if (month >= 13) {
			if (current < min)
				min = current;
			return;
		}

		if (month != 0) {
			cal(month + 3, current + quaterP);

			cal(month + 1, current + monthP);
			cal(month + 1, current + dayP * plan[month - 1]);
		} else {
			cal(month + 1, current);
		}

	}

}
