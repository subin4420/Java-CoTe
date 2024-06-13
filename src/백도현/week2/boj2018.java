import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

        int result = 0;

        for (int i = 1; i <= N; i++) {
            int tmp = 0;
            for (int j = i; j <= N; j++) {
                tmp += j;
                if (tmp > N) {
                    break;
                } else if (tmp == N) {
                    result++;
                    break;
                }
            }
        }
        


        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}