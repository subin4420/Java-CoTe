package week5;

import java.util.HashMap;
import java.util.Set;

public class Pgs42578_sm {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer = 1;

        HashMap<String, Integer> hm = new HashMap<>();
        for (String[] s : clothes) {
            hm.put(s[1], hm.getOrDefault(s[1],0)+1);
        }
        for(Integer v:hm.values()){
            answer *= v+1;
        }

        System.out.println(answer);
    }
}
