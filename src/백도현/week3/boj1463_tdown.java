import java.util.*;
import java.io.*;

class Main {

    // Integer 배열인 이유 : dp[n]번쨰에 연산이 되었는지 확인하기 위해
    // null값으로 중복 검사를 하기 위함
    // int[] 형 배열은 null값을 넣을 수 없음. Integer.MAX_VALUE를 넣던지 해야 함
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