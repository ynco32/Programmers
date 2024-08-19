
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int[] temp = new int[2];
			temp[0] = Integer.parseInt(st.nextToken());
			temp[1] = Integer.parseInt(st.nextToken());
			list.add(temp);
		}

		Collections.sort(list, (o1, o2) -> Integer.compare(o1[0], o2[0]));

		int total = 0;
		int start = list.get(0)[0];
		int fin = list.get(0)[1];
		for (int i = 1; i < list.size(); i++) {
			
			if (list.get(i)[0] <= fin) {
				fin = fin < list.get(i)[1] ? list.get(i)[1] : fin;
			}
			else {
				total += Math.abs(fin-start);
				start = list.get(i)[0];
				fin = list.get(i)[1];
			}
			
		}
		total += Math.abs(fin-start);
		System.out.println(total);
	}
}
