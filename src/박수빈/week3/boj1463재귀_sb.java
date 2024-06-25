import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int dp[];


    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n +1];
        dp[0] = dp[1] = 0;
        System.out.println(one(n));
    }

    public static int one(int n) {
        if (n == 1) {
            //n이 1일 경우 해야할 연산 0
            return 0;
        }
        if (dp[n]>0){
            return dp[n];
        }
        //1을 빼는 경우 1뺀걸로 재귀 -> 연산 1회 한 거니까 +1
        int min = one(n - 1) + 1;
        //2로
        if (n % 2 == 0) {
            return Math.min(min, one(n / 2) + 1);
        }
        //3으로
        if (n % 3 == 0) {
            return Math.min(min, one(n / 3) + 1);
        }
        dp[n] = min;
        return min;
    }
    }
