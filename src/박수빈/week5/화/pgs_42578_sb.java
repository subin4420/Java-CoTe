package cote_0701;
import java.util.*;
//의상
public class pgs_42578 {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 0;
            int size = clothes.length;
            int[] cnt = new int[size];
            int c = 1;

            HashMap<String, Integer> hm = new HashMap<>();
            for(String[] a : clothes){
                if(hm.containsKey(a[1])){
                    int b=hm.get(a[1]);
                    hm.put(a[1],b+1);
                }
                else{
                    hm.put(a[1],1);
                }
            }
            System.out.println("map is "+hm);

            Set<String> keys = hm.keySet();
            System.out.println("keys is "+keys);
            for(String a : keys){
                System.out.println("keys's cnt "+hm.get(a));
                c = c*(hm.get(a)+1);
            }
            return c-1;

        }
    }
}
