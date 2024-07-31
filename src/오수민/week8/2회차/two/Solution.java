package cote.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int box = score.length/m;
//        List<List<Integer>> boxes = new ArrayList<>();
        int cnt=score.length;
        for (int i = 0; i < box; i++) {
            answer += score[cnt-m]*m;
            cnt-=m;
//            List<Integer> row = new ArrayList<>();
//            for(int j = 0,idx=cnt; j<m ; j++, idx--) {
//                row.add(score[idx]);
//            }
//            cnt-=m;
//            boxes.add(row);
        }
//        for(List<Integer> row : boxes) {
//
//        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, 4, new int[]{1,2,3,1,2,3,1}));
    }
}
