package week6;

import java.io.*;
import java.util.*;

public class Boj2293_sm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] cnt = new int[k+1];
        cnt[0] = 1;

        for(int i=1;i<=N;i++){
            for(int j = arr[0];j<=k;j++){
                if(j<arr[i]){
                    continue;
                }
                cnt[j] += cnt[j-arr[i]];
            }
        }

        System.out.println(cnt[k]);
    }
}
