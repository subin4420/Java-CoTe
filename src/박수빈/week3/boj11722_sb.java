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
        int maxdp = 1;
        for (int i = 0; i < N ; i++) {
            seq[i] = sc.nextInt();
        }
        Arrays.fill( dp, 0);
        dp[N-1]= 1;
        for (int i = N-2; i >= 0; i--) {
            maxdp=0;
            for (int j = N-1; j > i; j--) {
                if(seq[j]<seq[i]){
                    //자기보다 뒤에 있는 요소가 자기보다 작은 요소가 있으면 dp를 확인해 가장 큰 값에서 +1 해서 가져온다
                    if(dp[j]>maxdp){
                        maxdp = dp[j];
                    }
                }//if
            }//jfor

            dp[i]=maxdp + 1;


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