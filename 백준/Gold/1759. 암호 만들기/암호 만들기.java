
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L;
	static int C;
	static char[] answer;
	static char[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		answer = new char[L];
		data = new char[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			data[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(data);
//		System.out.println(Arrays.toString(data));
		comb(0, 0);

	}

	static void comb(int target, int index) {
		if (target == L) {
//			System.out.println(Arrays.toString(answer));
			int vowel = 0;
			int consonant = 0;
			for (int i = 0; i < L; i++) {
				if (answer[i] == 'a' || answer[i] == 'e' || answer[i] == 'i' || answer[i] == 'o' || answer[i] == 'u')
					vowel++;
				else
					consonant++;
			}

			if (vowel >= 1 && consonant >= 2) {
				for (int i = 0; i < L; i++) {
					System.out.print(answer[i]);
				}
				System.out.println();
			}
			return;
		}

		for (int i = index; i < C; i++) {
			answer[target] = data[i];
			comb(target + 1, i + 1);
		}

	}
}
