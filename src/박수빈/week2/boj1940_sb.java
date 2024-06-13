import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //스캐너 정의
        Scanner sc = new Scanner(System.in);
        //과목수 N
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] a = new int[N];
        int start = 0;
        int cnt = 0;
        int end = N-1;

        for (int i = 0; i <N; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
    while (start<end){
        //System.out.printf("start = %d end = %d\n",start,end);
        if (a[start] + a[end] < M){
            //System.out.println("a[start] + a[end] < M");
            start++;
        }
        else if(a[start] + a[end] > M){
            //System.out.println("a[start] + a[end] > M");

            end--;
        }
        else {
            //System.out.println("a[start] + a[end] == M");
            start++;
            end--;
            cnt++;
        }
    }
        System.out.println(cnt);

    }
}