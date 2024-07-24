package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class leet60 {
    //시간초과 뜸
//    static class Solution {
//        public static boolean[] visit;
//        public static List<String> numArr;
//
//        public String getPermutation(int n, int k) {
//
//            visit = new boolean[n];
//            numArr = new ArrayList<>();
//
//            backtrack(n, "");
//
//            return numArr.get(k-1);
//        }
//
//        public static void backtrack(int n, String str){
//            if(n == str.length()){
//                numArr.add(str);
//                return;
//            }
//            for(int i = 1; i <= n; i++){
//                if(!visit[i-1]){
//                    visit[i-1] = true;
//                    backtrack(n, str+i);
//                    visit[i-1] = false;
//                }
//            }
//        }
//    }

    static class Solution {
        public static boolean[] visit;
        public static List<String> numArr;
        public static int count;

        public String getPermutation(int n, int k) {
            visit = new boolean[n];
            numArr = new ArrayList<>();
            count = 0;

            backtrack(n, k, new StringBuilder());

            return numArr.get(k - 1);
        }

        public static void backtrack(int n, int k, StringBuilder str) {
            if (str.length() == n) {
                numArr.add(str.toString());
                count++;
                if (count == k) {
                    return;
                }
            } else {
                for (int i = 1; i <= n; i++) {
                    if (!visit[i - 1]) {
                        visit[i - 1] = true;
                        str.append(i);
                        backtrack(n, k, str);
                        if (count == k) {
                            return;
                        }
                        str.deleteCharAt(str.length() - 1);
                        visit[i - 1] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int k = 9;

        System.out.println(solution.getPermutation(n, k));
    }
}
