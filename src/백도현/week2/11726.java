import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

        dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            if (i == 1) {
                dp[i] = 2;
                continue;
            }
            dp[i] = dp[i-1] + dp[i-2];
        }

        bw.write(dp[N-1] % 10007 + "\n");



        br.close();
        bw.flush();
        bw.close();
    }

}