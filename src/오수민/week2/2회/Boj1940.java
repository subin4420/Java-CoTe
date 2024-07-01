import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

//        int N = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//        int M = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());

//        한줄 받아올때는 buffer.readline()사용하기
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        long arr[] = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int p1 = 0, p2 = N - 1, cnt = 0;
        while (p1 < p2) {
            long sum = arr[p1] + arr[p2];
            if (sum > M) {
                p2--;
            } else if (sum < M) {
                p1++;
            } else {
                cnt++;
                p1++;
                p2--;

            }
        }
        System.out.println(cnt);
        br.close();
    }
}
