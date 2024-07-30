package ct_0730;
//타겟넘버
public class pgs_43165 {
    class Solution {
        int len;
        boolean[] visited;
        int a;
        public int solution(int[] numbers, int target) {
            int answer = 0;
            len = numbers.length;
            visited = new boolean[len];
            a=0;

            bt(0, numbers, target, 0);
            return a;
        }

        public void bt(int depth, int[] numbers, int target, int sum){
            if(depth == len){
                if(sum==target){
                    //System.out.println(sum+" "+target);
                    a++;
                }
                return;
            }
            bt(depth+1, numbers, target, sum + numbers[depth]);
            bt(depth+1, numbers, target, sum - numbers[depth]);

        }
    }
}
