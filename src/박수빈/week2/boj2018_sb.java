import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //스캐너 정의
        Scanner sc = new Scanner(System.in);
        //과목수 N
        int N = sc.nextInt();
        //N의 절반 보다 큰 경우는 연속된합으로 못함
        //투 포인터 문제
        //배열에서 인덱스를 2개를 가지고  배열을 탐색해 시간 복잡도를 낮추는 방법
        int sum = 0;
        int cnt = 0;
        int[] a =  new int[(N/2)+1];
        int start, end = 0;
//        System.out.println("a[] ==");
        for (int i = 0; i <N/2+1 ; i++) {
            a[i]=i+1;
//            System.out.print( a[i]);
        }
        for(start=0;start<N/2;start++){
//            System.out.printf("start = %d \n", start);
//            System.out.printf("end = %d \n", end);
            sum=0;
            end = start;
//            System.out.printf("end2 = %d \n", end);
//            System.out.printf("------for----- \n");

            while (sum < N) {
//                System.out.printf("sum = %d \n", sum);
                sum=sum+a[end];
//                System.out.printf("sum+a[end] = %d \n", sum);

                end++;
                if(sum==N){
                    cnt++;
                    //System.out.println("----break while----");
                    break;
                }
            }
        }
        System.out.println(cnt+1);
    }
}