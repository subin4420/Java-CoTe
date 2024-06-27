package algorithm;

import java.util.*;

public class psg138982_hj {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion){
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
//        System.out.println(map);

        for(String player : participant) { // participant의 각 선수 이름을 map에 넣고
            map.put(player, map.getOrDefault(player, 0) + 1); // 각 Participant의 count를 셈
//            System.out.println(map);
        }

        for(String player : completion) { // completion을 순회하면서 완주한 사람들의 Value 값을 -1
            map.put(player, map.get(player) - 1);
//            System.out.println(map);
        }

        // EntrySet을 이용하여 반복자를 생성
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

        // 반복자를 사용하여 맵의 모든 항목을 순회
        while(iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            if(entry.getValue() != 0) { // Value가 0이 아닌 사람이 완주하지 못한 사람 -> answer
                answer = entry.getKey();
                break;
            }
        }



//        while (iter.hasNext()) {
//            Map.Entry<String, Integer> entry = iter.next();
//            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//        }


/*       Queue 사용 -> 시간초과남
        Queue<String> queue = new LinkedList<>();

        for(int i = 0; i < participant.length; i++) {
            queue.add(participant[i]);
        }

        while(queue.size() == 1){
            for(int i = 0; i < queue.size(); i++) {
                if(Objects.equals(queue.peek(), completion[i])) {
                    queue.poll();
                }
            }
        }
        for (int i = 0; i < completion.length; i++) {
            String completedParticipant = completion[i];
            if (queue.contains(completedParticipant)) {
                queue.remove(completedParticipant);
            }
        }

       answer = queue.peek();
        */


        return answer;
    }
}



