import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int nOne = 0;
	static int zero = 0;
	static int pOne = 0;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		StringTokenizer st;
        //2차 배열로 입력 값 저장하기.
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		figureCnt(0, 0, n); //첫 인덱스 0,0과 row/column의 길이인 n 을 인수로 넣기.

		System.out.println(nOne + "\n" + zero + "\n" + pOne);
	}

	private static void figureCnt(int x, int y, int size) {
		if (sameNum(x, y, size)) {
			if (arr[x][y] == -1) {
				nOne++; //negative 1 (-1)
			} else if (arr[x][y] == 0) {
				zero++; // 0
			} else if (arr[x][y] == 1) {
				pOne++; // positive 1 (+1)
			}

		} else {
			int resize = size / 3;

			int[] xIdx = { x, x, x, x + resize, x + resize, x + resize, 
					x + (resize * 2), x + (resize * 2), x + (resize * 2) };
			int[] yIdx = { y, y + resize, y + (resize * 2), y, y + resize, 
					y + (resize * 2), y, y + resize, y + (resize * 2) };

			for (int i = 0; i < 9; i++) {
				figureCnt(xIdx[i], yIdx[i], resize);
			}
		}
	}

	private static boolean sameNum(int x, int y, int size) {
		if (size == 1) {
			return true;
		} else {
        //row나 column의 길이가 2 이상일 경우.
        //첫 인덱스의 값을 기준으로 다른 값과 같은지 비교하기.
			int firstIdx = arr[x][y];

			for (int i = x; i < x + size; i++) {
				for (int j = y; j < y + size; j++) {
                //다른 값이 검색되면 false를 반환하여 다시 9등분 하도록 보내기.
					if (arr[i][j] != firstIdx) {
						return false;
					}
				}
			}
            //다른 값이 검색되지 않았다면 true를 반환하기.
			return true;
		}

	}

}
