import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());

        if (N % 2 != 0) {
            bw.write("SK" + "\n");
        } else {
            bw.write("CY" + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}