
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> minus = new ArrayList<>();
		ArrayList<Integer> plus = new ArrayList<>();
		boolean zero = false;
		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(br.readLine());
			if (temp > 0)
				plus.add(temp);
			else if (temp < 0)
				minus.add(temp);
			else if (temp == 0) {
				zero = true;
			}
		}

		Collections.sort(plus);
		Collections.sort(minus);

		int total = 0;
		if (!minus.isEmpty()) {
			if (minus.size() % 2 == 0) {
				for (int i = 0; i < minus.size(); i += 2) {
					total += minus.get(i) * minus.get(i + 1);
				}
			}

			else {
				if (!zero)
					total += minus.get(minus.size()-1);
				for (int i = 0; i < minus.size()-1; i += 2) {
					total += minus.get(i) * minus.get(i + 1);
				}
			}
		}

		if (!plus.isEmpty()) {

			if (plus.size() % 2 == 0) {
				for (int i = 0; i < plus.size(); i += 2) {
					if (plus.get(i) == 1)
						total += plus.get(i) + plus.get(i + 1);
					else
						total += plus.get(i) * plus.get(i + 1);
				}
			}

			else {
				total += plus.get(0);
				for (int i = 1; i < plus.size(); i += 2) {
					if (plus.get(i) == 1)
						total += plus.get(i) + plus.get(i + 1);
					else
						total += plus.get(i) * plus.get(i + 1);
				}
			}
		}
		System.out.println(total);

	}

}
