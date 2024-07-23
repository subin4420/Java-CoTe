package algo0712;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class ddai {
    class Solution {
        boolean[] visited;
        List<List<Character>> result;
        List<Character> al;
        char[] arr;
        int len;

        public int solution(String numbers) {
            HashSet<Integer> hs = new HashSet<>();
            int answer = 0;
            len = numbers.length();
            visited = new boolean[len];
            al = new ArrayList<>();
            result = new ArrayList<>();
            arr = numbers.toCharArray();
            //길이가 1부터 len까지 시도
            for(int i=1;i<=len;i++)
                backtrack(0,i);
            // System.out.println(result.toString());
            // System.out.println();
            int cnt =0;
            for(int i=0;i<result.size();i++){
                // 문자 리스트를 문자열로 변환
                StringBuilder sb = new StringBuilder();
                for (Character ch : result.get(i)) {
                    sb.append(ch);
                }
                String str = sb.toString();
                hs.add(Integer.parseInt(sb.toString()));
            }
            for(Integer a : hs){
                if(isPrime(a)){
                    cnt++;
                }
            }
            return cnt;
        }
        //순열과 동일함
        public void backtrack(int depth, int m){
            if(depth == m){
                result.add(new ArrayList<Character>(al));
                return;
            }
            for(int i=0;i<len;i++){
                if(visited[i]) continue;
                visited[i] = true;
                al.add(arr[i]);
                backtrack(depth+1,m);
                al.remove(al.size()-1);
                visited[i] = false;
            }

        }
        //소수판별
        public boolean isPrime(int num){
            if(num==2){
                return true;
            }
            if(num%2 == 0){
                return false;
            }else if(num == 1){
                return false;
            }
            for(int i=2; i<(num)/2; i++){
                if(num%i == 0){
                    return false;
                }
            }
            return true;
        }
    }
    }


