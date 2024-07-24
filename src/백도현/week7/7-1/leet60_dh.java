import java.util.*;
class Solution {

    static List<String> list;
    static int[] facto, answer;
    public String getPermutation(int n, int k) {
        facto = new int[n+1];
        answer = new int[n+1];
        list = new ArrayList<>();
        setFactorial(n);
        dfs(n, k, 0, 0);
        String st = "";
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == answer[j])
                    st += j;
            }
        }
        return st;
    }

    public void setFactorial(int n) {
        facto[0] = 1;
        facto[1] = 1;
        for (int i = 2; i <= n; i++) {
            facto[i] = facto[i-1] * i;
        }
    }

    public void dfs(int n, int k, int order, int cnt) {
        for (int i = 1; i <= n; i++) {
            if (answer[i] != 0) continue;
            if (k > cnt + facto[n - order - 1]) {
                cnt += facto[n - order - 1];
                continue;
            }
            answer[i] = order + 1;
            dfs(n, k, order + 1, cnt);
            break;
        }
    }

    
}