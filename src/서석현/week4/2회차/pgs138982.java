package Programmers;

import java.util.Arrays;
import java.util.HashMap;

public class pgs138982 {
    public static void main(String[] args) {
        String[] participant = new String[]{"a", "b", "a", "d", "h"};
        String[] completion = new String[]{"b", "d" , "a",};

//        HashMap<Integer, String> h1 = new HashMap<>();
//        StringBuilder sb = new StringBuilder();
//
//        Arrays.sort(arr);
//        Arrays.sort(arr2);
//
//        for(int i = 0; i < arr.length; i ++){
//            h1.put(i, arr[i]);
//        }
//
//        System.out.println(h1.keySet());
//
//        for(int j = 0; j < arr2.length; j++) {
//            h1.remove(j, arr[j]);
//        }
//
//        for (String value : h1.values()) {
//            sb.append(value);
//        }
//
//        String answer = sb.toString();
//
//        System.out.println(answer);


        HashMap<String, Integer> hm = new HashMap<>();

        // 참가자 배열에서 각 이름의 빈도를 카운트
        for (String p : participant) {
            hm.put(p, hm.getOrDefault(p, 0) + 1);
        }

        // 완주한 선수 배열에서 각 이름의 빈도를 감소
        for (String f : completion) {
            hm.put(f, hm.get(f) - 1);
        }

        // 빈도가 0이 아닌 참가자를 찾기
        for (String p : hm.keySet()) {
            if (hm.get(p) != 0) {   //.get = // 특정 키의 값을 가져오기
                System.out.println(p);
                break;
            }
        }
    }
}
