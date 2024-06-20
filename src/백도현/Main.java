import java.util.*;
import java.io.*;

class Main {

    static Integer dp[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n +1];
        dp[0] = dp[1] = 0;
        System.out.println(one(n));
    }

    public static int one(int n) {
        if (dp[n] == null) {
            if (n % 6 == 0) {
                dp[n] = Math.min(one(n / 3), one(n / 2)) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(one(n / 3), one(n-1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(one(n / 2), one(n-1)) + 1;
            } else {
                dp[n] = one(n-1) + 1;
            }
        }
        return dp[n];
    }
}