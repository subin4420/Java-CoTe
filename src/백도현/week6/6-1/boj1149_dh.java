import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
        dp = new int [N][3];

        int answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = Integer.parseInt(st.nextToken());
            dp[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] += Math.min(dp[i-1][(j+1) % 3], dp[i-1][(j+2) % 3]);
            }
        }
        answer = Arrays.stream(dp[N-1]).min().getAsInt();
        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}