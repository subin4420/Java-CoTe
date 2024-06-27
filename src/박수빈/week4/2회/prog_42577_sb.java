package Q1;
import java.util.*;
public class prog_42577_sb {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i < phone_book.length; i++) {
                map.put(phone_book[i], phone_book[i]);
            }
            for (String phone : phone_book) {
                for (int i = 0; i < phone.length(); i++) {
                    if (map.containsKey(phone.substring(0, i))) {
                        return false;
                    }
                }
            }
            return answer;
        }
    }


