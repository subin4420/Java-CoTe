package algo0712;
import java.util.*;

public class candi {
    public static void main(String[] args) {
        String[][] relation = {
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}
        };

        System.out.println(solution(relation));  // 출력: 2
    }
        public static int solution(String[][] relation) {
            int n = relation[0].length;  // 속성의 개수
            List<Set<Integer>> candidates = new ArrayList<>();  // 후보 키가 될 속성 조합들

            // 백트래킹을 이용하여 후보 키를 찾음
            backtrack(relation, n, 0, new HashSet<>(), candidates);

            return candidates.size();  // 최종 후보 키의 개수를 반환
        }

        private static void backtrack(String[][] relation, int n, int start, Set<Integer> current, List<Set<Integer>> candidates) {
            // 유일성 검사
            if (isUnique(current, relation)) {
                // 최소성 검사
                for (Set<Integer> candidate : candidates) {
                    if (current.containsAll(candidate)) {
                        return;  // 최소성을 만족하지 않으면 반환
                    }
                }
                candidates.add(new HashSet<>(current));  // 후보 키로 추가
            }

            // 백트래킹으로 조합 생성
            for (int i = start; i < n; i++) {
                current.add(i);
                backtrack(relation, n, i + 1, current, candidates);
                current.remove(i);  // 다음 조합을 위해 현재 속성을 제거
            }
        }

        private static boolean isUnique(Set<Integer> combination, String[][] relation) {
            Set<String> seen = new HashSet<>();  // 중복을 확인하기 위한 집합
            for (String[] row : relation) {
                StringBuilder key = new StringBuilder();
                for (int col : combination) {
                    key.append(row[col]).append(",");
                }
                if (!seen.add(key.toString())) {  // 집합에 추가할 수 없으면 중복 발생
                    return false;  // 유일성을 만족하지 않음
                }
            }
            return true;  // 유일성을 만족함
        }
    }


//class Solution {
//    List<Integer> arr;
//    List<List<Integer>> res;
//    List<List<Integer>> candi;
//    int len;
//    int row;
//    public int solution(String[][] relation) {
//        int answer = 0;
//        len = relation[0].length;
//        row = relation.length;
//        System.out.println(row);
//        HashSet<List<Integer>> check = new HashSet<>();
//        arr=new ArrayList<>();
//        res=new ArrayList<>();
//        candi = new ArrayList<>();
//        for(int i=1;i<len;i++){
//            backtrack(0, i);
//
//            //중복체크해서 후보키 set에 넣을
//            for(int j=0;j<len;j++){
//                res.get(j);
//            }
//
//            System.out.println(res.toString());
//            res.clear();
//
//        }
//        return answer;
//    }
//
//    public void backtrack(int start, int m){
//        if(arr.size() == m){
//            res.add(new ArrayList(arr));
//            return;
//        }
//        for(int i=start;i<len;i++,start++){
//            arr.add(i);
//            backtrack(start+1,m);
//            arr.remove(arr.size()-1);
//        }
//
//    }
}