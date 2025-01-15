import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;
        int count = 0;
        int temp = 0;
        
        while (start < end) {
            temp = arr[start] + arr[end];
            if (temp > x) {
                end--;
            }
            else if (temp < x) {
                start++;
            }

            else {
                start++;
                end--;
                count++;
            }
        }
        System.out.println(count);
    }
}