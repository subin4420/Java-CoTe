import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        System.out.println(m(n));
        int[][] dp = new int[n+1][10];
        //앞자리가 1개 2개 3개 ... 2개일때는 1개일때를 사용
        //3개일때는 2개일때 결과값을 이용한다....

        //한자리일때 값 초기화
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }


        for (int i = 2; i <= n; i++) {
            //2자리부터 시작
            for (int j = 0; j < 10; j++) {
                //0부터9까지 확인
                for (int k = 0; k <= j; k++) {
                    //0일경우는 900일경우
                    //1일경우 800
                    //9일경우 100
                    //9일경우는 00 0~9 경우
                    dp[i][j]+=dp[i-1][k];
                    dp[i][j]%=10007;
                }
            }
        }
        int result=0;
        //앞자리가
        for (int i = 0; i < 10; i++) {
            //앞자리 0부터 9까지 모두 더해줌
            result+=dp[n][i];
            result%=10007;
        }
        System.out.println(result);
    }

//    public static int m(int n){
//        if(n==1)
//            return 1;
//        int sum = 0;
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i+"번째");
//            sum += (m(n-1)-i)*(m(n-1)-i+1)/2;
//            System.out.println((m(n-1)-i)*(m(n-1)-i+1)/2);
//        }
//
//        return sum;
//    }


}
