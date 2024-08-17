import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static char[][] map;
	static boolean[][][][] visited;
	static int gr;
	static int gc;
	static ArrayList<Integer> cnts;

	public static void main(String[] args) throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(buff.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		cnts = new ArrayList<>();
		visited = new boolean[N][M][N][M];

		int rr = 0, rc = 0, br = 0, bc = 0;

		for (int i = 0; i < N; i++) {
			String temp = buff.readLine();
			map[i] = temp.toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R') {
					rr = i;
					rc = j;
				} else if (map[i][j] == 'B') {
					br = i;
					bc = j;
				} else if (map[i][j] == 'O') {
					gr = i;
					gc = j;
				}
			}
		}

		roll(rr, rc, br, bc, 0);

		if (cnts.isEmpty()) {
			System.out.println(-1);
			return;
		}
		cnts.sort(null);
		System.out.println(cnts.get(0));

	}

	static void roll(int r, int c, int br, int bc, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		int[] s = { r, c, br, bc, cnt };
		q.offer(s);

		while (!q.isEmpty()) {
			int[] current = q.poll();
			visited[current[0]][current[1]][current[2]][current[3]] = true;
			if (current[4] > 9)
				return;

			int nr = current[0];
			int nbr = current[2];
			boolean add = true;
			boolean roll = true;
			boolean bflag = false;
			boolean rflag = false;
			while (roll && nr < N && nbr < N && current[1] < M && current[1] >= 0 && current[3] < M
					&& current[3] >= 0) {

				nr++;
				nbr++;

				if (map[nr][current[1]] == 'O') {
					rflag = true;
				}

				if (map[nbr][current[3]] == 'O') {
					bflag = true;
//					if (!rflag)
//						break;
				}

				if (map[nr][current[1]] == '#') {

					nr--;
					if ((nr == nbr && current[1] == current[3]) || map[nbr][current[3]] == '#') {
						nbr--;
						roll = false;
					}
				}
				if (map[nbr][current[3]] == '#') {
					nbr--;
					if ((nr == nbr && current[1] == current[3]) || map[nr][current[1]] == '#') {
						nr--;
						roll = false;
					}
				}

				if (nr == current[0] && nbr == current[2])
					add = false;
			}
			if (add && !visited[nr][current[1]][nbr][current[3]]) {
				if (!bflag && rflag) {
					cnts.add(current[4] + 1);
				} else if (!bflag && !rflag)
					q.offer(new int[] { nr, current[1], nbr, current[3], current[4] + 1 });
			}

			nr = current[0];
			nbr = current[2];
			bflag = false;
			rflag = false;
			add = true;
			roll = true;
			while (roll && nr >= 0 && nr < N && nbr < N && nbr >= 0 && current[1] < M && current[1] >= 0
					&& current[3] < M && current[3] >= 0) {

				nr--;
				nbr--;

				if (map[nr][current[1]] == 'O') {
					rflag = true;
				}

				if (map[nbr][current[3]] == 'O') {
					bflag = true;
//					break;
				}

				if (map[nr][current[1]] == '#') {

					nr++;
					if ((nr == nbr && current[1] == current[3]) || map[nbr][current[3]] == '#') {
						nbr++;
						roll = false;
					}
				}
				if (map[nbr][current[3]] == '#') {
					nbr++;
					if ((nr == nbr && current[1] == current[3]) || map[nr][current[1]] == '#') {
						nr++;
						roll = false;
					}
				}

				if (nr == current[0] && nbr == current[2])
					add = false;
			}
			if (add && !visited[nr][current[1]][nbr][current[3]]) {
				if (!bflag && rflag) {
					
					cnts.add(current[4] + 1);
				} else if (!bflag && !rflag)
					q.offer(new int[] { nr, current[1], nbr, current[3], current[4] + 1 });
			}

			int nc = current[1];
			int nbc = current[3];
			add = true;
			roll = true;
			rflag=false;
			bflag = false;
			while (roll && nc < M && nbc < M && current[0] < N && current[0] >= 0 && current[2] < N
					&& current[2] >= 0) {
				nc++;
				nbc++;

				if (map[current[0]][nc] == 'O') {
					cnts.add(current[4] + 1);
					return;
				}

				if (map[current[2]][nbc] == 'O') {
					add = false;
					break;
				}

				if (map[current[0]][nc] == '#') {

					nc--;
					if ((nc == nbc && current[0] == current[2]) || map[current[2]][nbc] == '#') {
						nbc--;
						roll = false;
					}
				}
				if (map[current[2]][nbc] == '#') {
					nbc--;
					if ((nc == nbc && current[0] == current[2]) || map[current[0]][nc] == '#') {
						nc--;
						roll = false;
					}
				}

				if (nc == current[1] && nbc == current[3])
					add = false;
			}
			if (add && !visited[current[0]][nc][current[2]][nbc]) {
				if (!bflag && rflag) {
					cnts.add(current[4] + 1);
				} else if (!bflag && !rflag)
					q.offer(new int[] { current[0], nc, current[2], nbc, current[4] + 1 });
			}
//			if (add) {
//				q.offer(new int[] { current[0], nc, current[2], nbc, current[4] + 1 });
//			}
			nc = current[1];
			nbc = current[3];
			add = true;
			roll = true;
			bflag = false;
			rflag = false;
			while (roll && nc >= 0 && nbc >= 0 && current[0] < N && current[0] >= 0 && current[2] < N
					&& current[2] >= 0) {
				nc--;
				nbc--;

				if (map[current[0]][nc] == 'O') {
					rflag = true;
				}

				if (map[current[2]][nbc] == 'O') {
					bflag = true;
				}

				if (map[current[0]][nc] == '#') {

					nc++;
					if ((nc == nbc && current[0] == current[2]) || map[current[2]][nbc] == '#') {
						nbc++;
						roll = false;
					}
				}
				if (map[current[2]][nbc] == '#') {
					nbc++;
					if ((nc == nbc && current[0] == current[2]) || map[current[0]][nc] == '#') {
						nc++;
						roll = false;
					}
				}

				if (nc == current[1] && nbc == current[3])
					add = false;
			}

			if (add && !visited[current[0]][nc][current[2]][nbc]) {
				if (!bflag && rflag) {
					cnts.add(current[4] + 1);
				} else if (!bflag && !rflag)
					q.offer(new int[] { current[0], nc, current[2], nbc, current[4] + 1 });
			}

		}

	}

}
