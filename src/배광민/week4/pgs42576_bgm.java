import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class pgs42576_bgm {
//    public String solution(String[] participant, String[] completion) {
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//
//        int i = 0;
//        for(i=0;i<completion.length;i++)
//            if(!participant[i].equals(completion[i]))
//                break;
//
//        return participant[i];
//    }
//
//    public static void main(String[] args){
//        String[] part = {"leo", "kiki", "eden"};
//        String[] comp = {"eden", "kiki"};
//        pgs42576_bgm sol = new pgs42576_bgm();
//        System.out.println(sol.solution(part, comp));
//    }

public String solution(String[] participant, String[] completion) {
    String answer = "";
    HashMap<String, Integer> map = new HashMap<>();
    for (String player : participant) {
        map.put(player, map.getOrDefault(player, 0) + 1);
    }
    for (String player : completion) {
        map.put(player, map.get(player)- 1);
    }

    Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

    while (iter.hasNext()) {
        Map.Entry<String, Integer> entry = iter.next();
        if (entry.getValue() != 0) {
            answer = entry.getKey();
            break;
        }
    }
    return answer;
}

    public static void main(String[] args){
        String[] part = {"leo", "kiki", "eden"};
        String[] comp = {"eden", "kiki"};
        pgs42576_bgm sol = new pgs42576_bgm();
        System.out.println(sol.solution(part, comp));
    }
}
