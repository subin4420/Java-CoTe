import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] dp, arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K+1];
        arr = new int[N];


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            int x = arr[i];
            for (int j = x; j <= K; j++) {
                dp[j] += dp[j - x];
            }
        }

        bw.write(dp[K] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}