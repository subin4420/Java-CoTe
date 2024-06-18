import java.util.*;

public class 가장긴증가하는부분수열_11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1); //길이 1로 초기화
        int max = 1; //최대 길이 1로 초기화

        // [1 1 1 1 1 1]
        //[10 20 10 30 20 50]
        // 기준 값보다 작은 값들 찾아서 dp값 갱신
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    //현재 dp값과 작은수 뒤로 들어갔을때의 dp값 비교해서 가장 큰 dp값 저장
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    // 이전 원소들 중 가장 큰 dp값 + 1
                }
            }
            max = Math.max(max, dp[i]); //현재 까지의 최대 길이 저장

        }

        System.out.println(max);
        System.out.println(Arrays.toString(dp));

    }
}