import java.util.*;

class leet_permutationSequence_bgm {
    public String getPermutation(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] nums = new int[n];
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            nums[idx] = i;
            idx++;
        }
        backtrack(new ArrayList<>(), nums, visited, result);
        String answer = "";
        answer += result.get(k);
        return answer;
    }

    void backtrack(List<Integer> curr, int[]nums, boolean[] visited, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                continue;
            }
            curr.add(nums[i]);
            visited[i] = true;
            backtrack(curr, nums, visited, result);
            curr.remove(nums[i]);
            visited[i] = false;
        }
    }
}