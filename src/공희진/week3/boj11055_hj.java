import java.util.*;

public class 가장큰증가하는부분수_11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;
        int[] dp = new int[n];

        for (int i = 0; i < dp.length; i++) {
            //dp배열을 arr배열로 초기화 => 비교 기준이 각 요소들의 합의 크기를 비교함
            dp[i] = arr[i];

            // 기준 값보다 작은 값들 찾아서 dp값 갱신
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    //d[i] =이전번째까지의 합(d[j]) +  자신의 값(a[i])
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            max = Math.max(max, dp[i]);

        }
        System.out.println(Arrays.toString(dp));
        System.out.println(max);
    }
}
