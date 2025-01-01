import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // 1. B의 제곱근까지 소수 판별
        int len = (int) Math.sqrt(B);
        boolean[] isPrime = new boolean[len + 1];
        for (int i = 2; i <= len; i++) {
            isPrime[i] = true; // 초기값: 모두 소수로 설정
        }

        for (int i = 2; i * i <= len; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= len; j += i) {
                    isPrime[j] = false; // 소수가 아님
                }
            }
        }

        // 2. 거의 소수 계산
        int ans = 0;
        for (int i = 2; i <= len; i++) {
            if (isPrime[i]) {
                long temp = (long) i * i; // i의 최소 제곱
                while (temp <= B) {
                    if (temp >= A) {
                        ans++;
                    }
                    // 다음 거듭제곱
                    if (temp > Long.MAX_VALUE / i) break; // 오버플로우 방지
                    temp *= i;
                }
            }
        }

        System.out.println(ans);
    }
}
