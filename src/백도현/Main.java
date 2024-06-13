import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = i + 1; j < N; j++) {

                if (arr[i] + arr[j] == M) {
                    result++;
                }
            }
        }
        


        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}