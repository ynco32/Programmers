
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> post, in;
	static int N, idx;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		post = new ArrayList<>();
		in = new ArrayList<>();

		idx = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			in.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			post.add(Integer.parseInt(st.nextToken()));
		}
		pre(0, N - 1, 0, N - 1);
		System.out.println(sb);
	}

	static void pre(int in_start, int in_last, int post_start, int post_last) {
		if (in_start <= in_last && post_start <= post_last) {

			int num = post.get(post_last);
			sb.append(num).append(" ");
			int newIdx = 0;
			for (int i = in_start; i <= in_last; i++) {
				if (in.get(i) == num) {
					newIdx = i;
					break;
				}
			}

//			int newIdx = in.indexOf(num);
			pre(in_start, newIdx - 1, post_start, post_start + newIdx - in_start - 1);
			pre(newIdx + 1, in_last, post_start + newIdx - in_start, post_last - 1);
		}
	}
}
