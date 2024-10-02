
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] mag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		mag = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String temp = br.readLine();
			for (int j = 0; j < 8; j++) {
				mag[i][j] = temp.charAt(j) - '0';
			}
		}
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());

			// left
			int idx = num;
			int dirT = dir * -1;
			int last = mag[idx][6];
			while (idx < 4 && idx > 0) {
				if (last != mag[idx - 1][2]) {
					last = mag[idx - 1][6];
					if (dirT == 1)
						clockwise(idx - 1);
					else
						counterClockwise(idx - 1);
					idx--;
					dirT *= -1;
				} else
					break;
			}

			// right

			idx = num;
			dirT = dir * -1;
			last = mag[idx][2];
			while (idx < 3 && idx >= 0) {
				if (last != mag[idx + 1][6]) {
					last = mag[idx + 1][2];
					if (dirT == 1)
						clockwise(idx + 1);
					else
						counterClockwise(idx + 1);
					idx++;
					dirT *= -1;
				} else
					break;
			}

			if (dir == 1)
				clockwise(num);
			else
				counterClockwise(num);
		}

		int ans = mag[0][0] * 1 + mag[1][0] * 2 + mag[2][0] * 4 + mag[3][0] * 8;
		System.out.println(ans);

	}

	private static void counterClockwise(int index) {
		int temp[] = new int[8];
		for (int i = 0; i < 8; i++)
			temp[i] = mag[index][i];
		for (int i = 0; i < 7; i++) {
			mag[index][i] = temp[i + 1];
		}
		mag[index][7] = temp[0];
	}

	private static void clockwise(int index) {
		int temp[] = new int[8];
		for (int i = 0; i < 8; i++)
			temp[i] = mag[index][i];

		for (int i = 1; i < 8; i++) {
			mag[index][i] = temp[i - 1];
		}
		mag[index][0] = temp[7];

	}
}
