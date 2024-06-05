import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11659_bgm {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int suNo = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());
        long[] S = new long[suNo + 1];
        st = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= suNo; i++) {
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }
        for (int q = 0; q < quizNo; q++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(S[j] - S[i - 1]);
        }
    }
}
