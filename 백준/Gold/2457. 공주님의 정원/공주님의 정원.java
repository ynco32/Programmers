import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

import static java.util.Collections.sort;


public class Main {

    static class Flower implements Comparable<Flower>{
        int start;
        int end;

        public Flower(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            if (this.start == o.start){
                return o.end-this.end;
            }
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Flower> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startM = Integer.parseInt(st.nextToken());
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endD = Integer.parseInt(st.nextToken());

            list.add(new Flower(startM * 100 + startD, endM * 100 + endD));
        }

        Collections.sort(list);

        int startP = 301;
        int endP = 1201;
        int idx = 0;
        int max = 0;
        int ans = 0;

        while (startP < endP){
            boolean flag = false;
            for (int i = idx; i < N; i++){
                Flower current = list.get(i);

                if (current.start > startP) break;
                if (current.end > max) {
                    max = current.end;
                    flag = true;
                    idx = i + 1;
                }
            }

            if (flag) {
                ans++;
                startP= max;
            }
            else break;
        }

        if (max < endP) System.out.println(0);
        else System.out.print(ans);


    }


}