import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //스캐너 정의
        Scanner sc = new Scanner(System.in);
//        6
//        10 20 10 30 20 50
        int N = sc.nextInt();
        int[] seq = new int[N];
        int[] dp = new int[N];
        int maxdp=0;
        for (int i = 0; i < N ; i++) {
            seq[i] = sc.nextInt();
            dp[i] = seq[i];
        }

        for (int i = 1; i < N; i++) {
            maxdp=0;
            for (int j = 0; j < i; j++) {
                if(seq[j]<seq[i]){
                    //자기보다 뒤에 있는 요소가 자기보다 작은 요소가 있으면 dp의 값을 확인
                    if(dp[j]>maxdp){
                        maxdp = dp[j];
                    }
                }//if
            }//jfor

            dp[i]=dp[i] + maxdp;


            //System.out.println(dp[i]);
        }//ifor
        for (int i = 0; i < N; i++) {
            //System.out.println(dp[i]);
            if(dp[i] > maxdp){
                maxdp = dp[i];
            }
        }
        System.out.println(maxdp);
    }
}