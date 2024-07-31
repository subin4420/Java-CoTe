package cote.one;

class Solution {
    public int solution(String s) {
        String[] nums = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String[] chars = s.split("");

        String answer = "";
        String number = "";
        for(String ch : chars) {
            try{
                int intNum = Integer.parseInt(ch);
                answer += intNum+"";
            }catch(Exception e){
                number+=ch;
                for(int i=0;i<nums.length;i++) {
                    if(number.equals(nums[i])) {
                        answer+=i+"";
                        number="";
                    }
                }
            }
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("one4seveneight");
        System.out.println();
    }
}