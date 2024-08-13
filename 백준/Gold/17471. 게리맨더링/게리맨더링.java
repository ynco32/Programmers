
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] people;
	static LinkedList<Integer>[] graph;
	static int[] map;
	static int[] map2;
	static boolean[] nodes;
	static ArrayList<Integer> diffs = new ArrayList<>();
	static int[] group;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		people = new int[N+1];
		group = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		graph = new LinkedList[N+1];
		for (int i = 0; i < N; i++) {
			people[i+1] = Integer.parseInt(st.nextToken());
			graph[i+1] = new LinkedList<Integer>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			for (int j = 0; j < len; j++) {
				int con = Integer.parseInt(st.nextToken());
				graph[i+1].add(con);
			}
		}
		
		for (int i = 1; i <= N; i++) {
			graph[i].sort(null);
//			System.out.println(graph[i].toString());			
		}
		
		
		/* --- 그래프 입력 받음 ! --- */
		// 2개 그룹으로 나누는 경우의 수 ( { 1, N-1 }, { 2, N-2 }, ... { N/2, N/2 (+1 홀수일때)} )
		for (int r = 1; r <= N/2; r++) {
			nodes = new boolean[N+1];
			map = new int[r];
			map2 = new int[N-r];
			// comb(idx, targetIdx, r)
			comb(0, 0, r);
		}
		
//		System.out.println(diffs.toString());
		if (diffs.isEmpty()) {
			System.out.println(-1);
			return;
		}
		diffs.sort(null);
		System.out.println(diffs.get(0));
		
		
	}
	
	
	static void comb(int idx, int targetIdx, int r) {
		
		if (targetIdx == r) {
			// 조합 완성!
			int idxMap2 = 0;
			for (int i = 0; i < N; i++) {
				if (!nodes[i+1]) {
					map2[idxMap2++] = i+1;
					group[i+1] = 2;
				}
			}
//			System.out.println(Arrays.toString(map) + " " +Arrays.toString(map2));
			
			
			// 단지번호붙이기............
			boolean flag = checkMap();
			
			
			// 잘 연결되어있으면 비교합시다...
			if (flag) {
				int people1 = 0;
				int people2 = 0;
				
				for (int i = 0; i < r; i++) {
					people1 += people[map[i]];
				}
				
				for (int i = 0; i < N-r; i++) {
					people2 += people[map2[i]];
				}
				
				diffs.add(Math.abs(people1-people2));
			}
			
			return;
		}
		
		
		for (int i = idx; i < N; i++) {
			map[targetIdx] = i+1;
			nodes[i+1] = true;
			group[i+1] = 1;
			comb(i+1, targetIdx+1, r);
			nodes[i+1] = false;
			group[i+1] = 0;
		}
		
		
		return;
	}
	
	static boolean checkMap() {
		// map 1 부터 검사하고...
		Queue<Integer> q1 = new LinkedList<>();
		q1.offer(map[0]);
		boolean[] visited1 = new boolean[N+1];
		visited1[map[0]] = true;
		while (!q1.isEmpty()) {
			int num = q1.poll();
			for (int i = 0; i < graph[num].size(); i++) {
				int temp = graph[num].get(i);
				if (!visited1[temp] && group[temp] == 1) {
					q1.offer(temp);
					visited1[temp] = true;
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			if (!visited1[map[i]]) return false;
		}
		
		
		
		
		// map 2 도 검사해야지...
		Queue<Integer> q2 = new LinkedList<>();
		q2.offer(map2[0]);
		boolean[] visited2 = new boolean[N+1];
		visited2[map2[0]] = true;
		while (!q2.isEmpty()) {
			int num = q2.poll();
			for (int i = 0; i < graph[num].size(); i++) {
				int temp = graph[num].get(i);
				
				if (!visited2[temp] && group[temp] ==2) {
					q2.offer(temp);
					visited2[temp] = true;
				}
			}
		}
		
		for (int i = 0; i < map2.length; i++) {
			if (!visited2[map2[i]]) return false;
		}
		return true;
	}
}
