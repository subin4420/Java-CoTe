import java.util.Scanner;

public class Boj2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int s_i = 1, e_i = 1, sum = 1, cnt = 1;

//        while(s_i<N){ //s_i가 끝까지 이동할 필요 없음, e_i가 N이 된 순간 더 이상 sum==N이 될 수 없음
        while (e_i != N) {
            if (sum > N) {
                sum -= s_i;
                s_i++;
            } else if (sum < N) {
                e_i++;
                sum += e_i;
            } else {
                e_i++;
                sum += e_i;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
