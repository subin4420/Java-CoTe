package algo3.후보키;

import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;

        int row = relation.length;
        int col = relation[0].length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1;i<=col;i++){
            backtrack(col, i, 0, new ArrayList<>(), res, relation);
        }

        answer = res.size();
        return answer;
    }

    void backtrack(int n, int k, int start, List<Integer> curr, List<List<Integer>> res, String[][] relation){
        if(curr.size() == k){
            boolean hasCommonElement = false;
            for (List<Integer> sublist : res) {
                for (Integer num : sublist) {
                    if (curr.contains(num)) {
                        hasCommonElement = true;
                    }
                    else{
                        hasCommonElement = false;
                        break;
                    }
                }
                if(hasCommonElement){break;}
            }
            if (!hasCommonElement) {
                Set<String> set = new HashSet<>();
                for(int j=0;j<relation.length;j++){
                    String tmp = "";
                    for(int i:curr){
                        tmp +=relation[j][i]+"_";
                    }
                    set.add(tmp);
                }
                if(set.size()==relation.length){
                    res.add(new ArrayList<>(curr));
                }
            }
            return;
        }
        for(int i=start;i<n;i++){
            curr.add(i);
            backtrack(n,k,i+1,curr,res, relation);
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] relation = new String[][]{
                {"a","1","aaa","c","ng"},
                {"a","1","bbb","e","g"},
                {"c","1","aaa","d","ng"},
                {"d","2","bbb","d","ng"}};
        System.out.println(solution.solution(relation));
    }
}