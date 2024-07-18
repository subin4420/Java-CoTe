import java.util.*;
class Solution {
    int answer, size;
    
    public int solution(String[][] relation) {
        answer = 0;
        size = relation[0].length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            dfs(relation, i, 0, list, new ArrayList<>());
        }
        return list.size();
    }
    
    public void dfs(String[][] relation, int n, int start, List<List<Integer>> list, List<Integer> now) {
        if (n == now.size()) {
            Set<List<String>> set = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                List<String> tmp = new ArrayList<>();
                for (int x: now) {
                    tmp.add(relation[i][x]);
                }
                set.add(tmp);
            }
            if (set.size() == relation.length) {
                boolean flag = true;
                for (List<Integer> x : list) {
                    int cnt = 0;
                    for (int y : now) {
                        if (x.contains(y)) {
                            cnt++;
                        }
                    }
                    if (cnt == x.size()) {
                        flag = false;
                    }
                }
                if (flag) {
                    list.add(new ArrayList<>(now));
                }
            }
            return;
        }
        
        for (int i = start; i < size; i++) {
            now.add(i);
            dfs(relation, n, i+1, list, now);
            now.remove(now.size() - 1);
        }
    }
}