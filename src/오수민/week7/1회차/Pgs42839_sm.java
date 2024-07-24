package algo3.소수찾기;

import java.util.HashSet;
import java.util.Set;

public class Solution_my {
    public int solution(String numbers) {
        int answer = 0;
        int len = numbers.length();
        int[] intArr = new int[len];
        boolean[] visit = new boolean[len];
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<len;i++){
            intArr[i] = Integer.parseInt(numbers.charAt(i)+"");
        }

        for(int i=1;i<=len;i++){
            //i = 자리수
            backtrack(intArr,i,visit,"",0,set);
        }
        answer = set.size();
        return answer;
    }

    public void backtrack(int[] nums,int k,boolean[] visit, String tmp,int cnt,Set<Integer> set) {
        if(tmp.length()==k){
            if(isPrime(Integer.parseInt(tmp))){
                set.add(Integer.parseInt(tmp));
            }
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visit[i]){
                visit[i] = true;
                backtrack(nums,k,visit,tmp+nums[i],cnt+1,set);
                visit[i] = false;
            }
        }
    }

    public boolean isPrime(int n){
        if(n<=1) return false;
        if(n==2) return true;
        if(n%2==0) return false; //짝수 걸러짐
        int sqrt = (int) Math.sqrt(n);
        for(int i=3;i<=sqrt;i+=2){ //짝수 제외, 홀수만 판별
            if(n%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_my solution_my = new Solution_my();
        int answer = solution_my.solution("17");
        System.out.println(answer);
    }
}
