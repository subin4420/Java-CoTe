package algorithm.week4;

import java.util.HashMap;
import java.util.Map;

public class psg138986_hj {
        public static void main(String[] args) {
            String[] phone_book = {"123","456","789"};
            System.out.println(solution(phone_book));
        }

        public static boolean solution (String[] phone_book) {
            boolean answer = true;
            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i < phone_book.length; i++) {
                map.put(phone_book[i], i );
            }

            for(int i = 0; i < phone_book.length; i++) {
                for(int j = 1; j < phone_book[i].length(); j++) {
                    //전화번호의 존재 유무 확인
                    if(map.containsKey(phone_book[i].substring(0,j))) {
                        answer = false;
                    }
                }
            }
            return answer;
        }
    }

