package 공희진.week5;
//의상
import java.util.HashMap;

public class pgs42578_hj {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }
    public static int solution(String[][] clothes){
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;

        for(int i=0; i < clothes.length; i++) {
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1], 0)+1); // 의상 종류별로 개수 저장
        }

        //머리 - 2개
        //안경 - 1개
        //(1+1) * (2+1) - 1
        for (String s : map.keySet()) {
            answer *= (map.get(s)+1); // 조합 안입는 경우 고려 -> -1
        }


        //eye -1개
        //head - 2개
        //clothes.length + max(map.getValue)
//시간 초과
//
//           for (String key : map.keySet()) {
//               if(map.size() > 1) {
//                   if(max < map.get(key)) {
//                       max = map.get(key);
//                   }
//                   answer = clothes.length + max;
//               } else {
//                   answer = map.get(key);
//               }
//           }

        return answer-1; // 모두 안입었을 경우 -> -1
    }
}
