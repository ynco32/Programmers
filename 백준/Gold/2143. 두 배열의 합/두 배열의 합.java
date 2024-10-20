import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[] A, B;
	static int T, NA, NB;
	static ArrayList<Integer> sumA, sumB;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		NA = Integer.parseInt(br.readLine());
		A = new int[NA];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < NA; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		sumA = new ArrayList<>();
		for (int i = 0; i < NA; i++) {
			int temp = A[i];
			sumA.add(temp);
			for (int j = i + 1; j < NA; j++) {
				temp += A[j];
				sumA.add(temp);
			}
		}
		Collections.sort(sumA);

		NB = Integer.parseInt(br.readLine());
		B = new int[NB];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < NB; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		sumB = new ArrayList<>();
		for (int i = 0; i < NB; i++) {
			int temp = B[i];
			sumB.add(temp);
			for (int j = i + 1; j < NB; j++) {
				temp += B[j];
				sumB.add(temp);
			}
		}
		Collections.sort(sumB);

		long answer = 0;
		for (int x : sumA) {
			answer += upperBound(T - x) - lowerBound(T - x);
		}
//		System.out.println(sumA);
//		System.out.println(sumB);
		System.out.println(answer);
	}

	private static int lowerBound(int remind) {
		int left = 0;
		int right = sumB.size();
		while (left < right) {
			int mid = (left + right) / 2;
			if (sumB.get(mid) >= remind) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

	
	private static int upperBound(int remind) {
		int left = 0;
		int right = sumB.size();
		while (left < right) {
			int mid = (left + right) / 2;
			if (sumB.get(mid) <= remind) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}
}
