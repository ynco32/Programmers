
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Person implements Comparable<Person> {
		int age;
		String name;
		int cnt;

		Person(int age, String name, int cnt) {
			this.age = age;
			this.name = name;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Person o) {

			if (o.age == this.age) {
				return this.cnt - o.cnt;
			}

			return this.age - o.age;
		};
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Person> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name =st.nextToken();
			list.add(new Person(age, name, i));
		}
		
		Collections.sort(list);
		for (Person p : list) {
			sb.append(p.age).append(" ").append(p.name).append("\n");
		}
		System.out.println(sb);
	}
}
