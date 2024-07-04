package algorithm.week5;
//롤케이크 자르기
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class pgs132265_hj {
    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(solution(topping));
    }
    public static int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i < topping.length; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0)+1);
        }


        // set - 1 2
        // map - 1=4, 2=1, 3=1, 4=1

        // set - 1 2
        // map - 1=3, 2=1, 3=1, 4=1

        // set - 1 2 3
        // map - 1=3, 2=1, 4=1
        //  set.size() == map.size() -> answer = 1;

        for (int i = 0; i < topping.length; i++) {
            set.add(topping[i]);
            map.put(topping[i], map.get(topping[i])-1 );
            if(map.get(topping[i]) == 0) {
                map.remove(topping[i]);
            }
            if(set.size() == map.size()) {
                answer++;
            }
        }


        return answer;

    }
}