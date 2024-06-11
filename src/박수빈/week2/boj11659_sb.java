import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //스캐너 정의
        Scanner sc = new Scanner(System.in);
        //과목수 N
        /* psudo code
        *시간 복잡도 O(N+M) 메모리 258844KB 시간 2336ms
        *첫줄 N, M 입력 받기 -> N 2개, M크기 만큼의 배열 만들기
        *두 번째 줄 N배열에 받기
        *그 후 N배열에 대한 합배열 만들기
        *M회 들어오는 i j 에 대한 부분합을 s[j] - s[i-1]를 이용해 구한다.
        *M크기의 배열에 저장한다.
        *완료 후 출력
        * */
        //첫 줄 입력 받기
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int[] ij = new int[M];
        int[] sum = new int[N];
        int i, j=0;

        //두 번째 줄 입력 받기
        for(int n=0;n<N;n++){
            arr[n] = sc.nextInt();
        }
        //합 배열 첫 원소는 동일
        sum[0] = arr[0];
        //합 배열
        for(int n=1;n<N;n++){
            sum[n] = sum[n-1]+ arr[n];
        }
        //M회 들어올 ij 처리
        for(int m = 0; m <M; m++){
            i = sc.nextInt();
            j = sc.nextInt();
            if(i==1){
                ij[m]= sum[j-1];
            }else{
                ij[m]=sum[j-1]-sum[i-2];
            }
        }
        //ij값 출력 마지막만 \n 안하게 if 조건
        for(int m=0;m<M;m++){
            if(m==M-1){
                System.out.print(ij[m]);
            }else{
                System.out.println(ij[m]);
            }
        }
    }

}