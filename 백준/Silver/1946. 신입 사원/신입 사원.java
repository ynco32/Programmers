import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

class Employee implements Comparable<Employee> {
    int paper;
    int interview;

    Employee (int paper, int interview) {
        this.paper = paper;
        this.interview = interview;
    }

    @Override
    public int compareTo(Employee o) {
        // 서류순위를 기준으로 오름차순 정렬
        return this.paper - o.paper;
    }
}

public class Main {
    static int T, N;
    static ArrayList<Employee> list;

    void Solve() {
        int ans = 1; // 서류1등은 일단 무조건 합격임
        int pivot = list.get(0).interview; //서류 1등의 면접점수를 기준점으로 삼음
        for (int i=1; i<N; i++) { // 서류 2등부터 비교 시작
            if (list.get(i).interview < pivot) {
                // 현재 지원자의 면접 순위가 앞의 수위보다 높다면 합격
                ans++; // 합격자수 증가
                pivot = list.get(i).interview; // 기준을 현재 인터뷰 순위로 교체
            }
        }
        System.out.println(ans);
    }
 
    public static void main(String[] args) throws Exception {
        Main m = new Main();
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for (int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new Employee(a, b));
            }
            Collections.sort(list);//오름차순 정렬
            m.Solve();
        }
    }
}