package algorithm;

import java.util.HashMap;

public class Pgm138986 {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean answer = true;

        HashMap<String, Integer> map = new HashMap<>();
        for(String phone: phone_book) {
            map.put(phone, 1);
        }

        for(String phone: phone_book) {
            for(int i=0;i<phone.length();i++){
                if(map.containsKey(phone.substring(0,i))){
                    answer = false;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

}
