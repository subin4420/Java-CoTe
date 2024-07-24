package algorithm.week7;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/permutation-sequence/
public class leete60_hj {
    public static boolean[] visited;
    public static List<String> list;
    public static String answer = "";
    public static int num = 0;

    public static void main(String[] args) {
        int n = 9;
        int k = 214267;
        System.out.println(getPermutation(n,k));
    }
    public static String getPermutation(int n, int k) {
        visited = new boolean[n+1];
        list = new ArrayList<>();
        num = n;
        backtrack(n,0);
        answer = list.get(k-1);
        return answer;
    }

    public static void backtrack(int n, int curr) {
        if(n==0) {
            list.add(curr + "");
            return;
        }
        for(int i = 1; i <= num; i++) {
            if(!visited[i-1]) {
                visited[i-1] = true;
                int newValue = curr + i * (int) (Math.pow(10, n - 1));
                backtrack(n - 1, newValue);

                visited[i-1] = false;
            }
        }
    }
}
