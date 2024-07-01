package Programmers;

import java.util.Arrays;

public class pgs138986 {
    static class Solution {
        public boolean solution(String[] phone_book) {
//            for(int i = 0; i < phone_book.length; i++) {
//                for(int j = 0; j < phone_book.length; j++) {
//                    if(i != j && phone_book[i].startsWith(phone_book[j])) {
//                        return false;
//                    }
//                }
//            }
//            return true;


            // 1. phoneBook을 sorting한다.
            Arrays.sort(phone_book);

            // 2. 1중 Loop을 돌며 앞 번호가 뒷 번호의 접두어인지 확인한다.
            for (int i = 0; i < phone_book.length - 1; i++)
                if (phone_book[i + 1].startsWith(phone_book[i]))
                    return false;

            // 3. 여기까지 오면 접두어가 없다는 것이다.
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = new String[]{"119", "97674223", "1195524421"};

        System.out.println(solution.solution(arr));
    }
}
