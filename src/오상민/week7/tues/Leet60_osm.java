/**
 * Permutation Sequence
 */
class Solution {
    boolean[] visited;
    String answer = "";
    int num = 0;
    ArrayList<String> ans = new ArrayList<String>();

    void dfs(int current, int n) {
        if (n == 0) {
            ans.add(current + "");
            return;
        }

        for (int i = 1; i <= num; i++) {
            if (!visited[i - 1]) {
                visited[i - 1] = true;
                int newValue = current + i * (int) (Math.pow(10, n - 1));
                dfs(newValue, n - 1);
                visited[i - 1] = false;
            }
        }
    }

    public String getPermutation(int n, int k) {
        visited = new boolean[n];
        num = n;
        dfs(0, n);
        answer = ans.get(k - 1);
        return answer;
    }
}