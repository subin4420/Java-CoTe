import java.util.ArrayList;
import java.util.List;

class Lc60_sm {
    public String getPermutation(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        backtrack(n,k,visited,new ArrayList<>(),res);
        List<Integer> tmp = res.get(k-1);
        StringBuilder sb = new StringBuilder();
        for(Integer i : tmp){
            sb.append(i);
        }

        return sb.toString();
    }
    boolean backtrack(int n, int k, boolean[] visited, List<Integer> curr, List<List<Integer>> res){
        if(curr.size()==n){
            res.add(new ArrayList<>(curr));
            if(res.size()==k) return false;
            return true;
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                curr.add(i+1);
                if(backtrack(n,k,visited,curr,res)){
                    visited[i] = false;
                    curr.remove(curr.size()-1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3, 3));
    }
}