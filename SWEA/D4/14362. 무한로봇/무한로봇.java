
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int ans, x, y, dir;
	static char[] command;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(in.readLine());
		for (int t = 1; t <= tc; t++) {
			command = in.readLine().toCharArray();
			ans = 0;
			x = 0;
			y = 0;
			dir = 0;
			sb.append("#").append(t).append(" ");
			if (isInfinity())
				sb.append("oo");
			else
				sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static boolean isInfinity() {
		for (int i = 0; i < 4; ++i) {
			go();
			if (x == 0 && y == 0)
				return false;
			if (dir == 0)
				return true;
		}
		return false;
	}

	static void go() {
		for (char c : command) {
			switch (c) {
			case 'S':
				x += dx[dir];
				y += dy[dir];
				ans = Math.max(ans, x * x + y * y);
				break;
			case 'L':
				dir = (dir + 1) % 4;
				break;
			case 'R':
				dir = (dir + 3) % 4;
				break;
			}
		}
	}
}
