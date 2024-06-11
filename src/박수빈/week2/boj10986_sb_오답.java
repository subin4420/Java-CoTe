import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //스캐너 정의
        Scanner sc = new Scanner(System.in);
        //과목수 N
        /* 아이디어
         *  ij 간의 구간합을 구하는 공식이 S[j] - S[i-1]
         *  이 과정에서 둘의 나머지가 빼지게 된다
         *  이 때 부분합의 나머지가 같다면 나머지가 사라지고 해당 값으로 나눠떨어진다.
         *
         * */
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int[] sum = new int[N];
        int[] cnt = new int[M];
        int result = 0;
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
            if(i!=0) sum[i]=(sum[i-1]+arr[i])%M;
            else sum[i]=arr[i]%M;
        }
        for (int i = 0; i < N; i++) {
            if(sum[i]==0){
                result=result+1;
            }
            cnt[sum[i]]++;

        }
        for (int i = 0; i < M; i++) {
            if(cnt[i]>1){
                result = result + (cnt[i]*(cnt[i]-1)/2);
            }
        }
        System.out.println(result);
    }
}