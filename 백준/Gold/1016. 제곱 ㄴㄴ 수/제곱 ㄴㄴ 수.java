import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static boolean[] check;
    static long min, max;
    static int diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());
        diff = (int) (max-min+1);
        check = new boolean[diff];
        getPrime();
        System.out.println(diff);
    }

    static void getPrime(){
        for (long i = 2; i <= (int)Math.sqrt(max); i++){
            long pow = i*i;
            long tmp = min / pow;
            if (min % pow != 0){
                tmp++;
            }

            for (long j = tmp; j * pow <= max; j++){
                int idx = (int)(j*pow - min);
                if (!check[idx]){
                    check[idx] = true;
                    diff--;
                }
            }
        }
    }
}