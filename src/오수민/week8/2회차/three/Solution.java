package cote.three;

import java.util.*;

public class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
//        List<List<Double>> times = new ArrayList<>();
//        double[][] times = new double[book_time.length][book_time[0].length];
//        List<PriorityQueue<Double>> startList = new ArrayList<>();
//        List<PriorityQueue<Double>> endList = new ArrayList<>();
        ArrayList<Double> start = new ArrayList<>();
        ArrayList<Double> end = new ArrayList<>();

        PriorityQueue<Double> st = new PriorityQueue<>();
        int cnt = 0;
        for(String[] book:book_time){
            String startTime = book[0];
            double startD = Integer.parseInt(startTime.substring(0, 2))+Integer.parseInt(startTime.substring(3))*0.01;
            st.add(startD);

            String endTime = book[1];
            double endD = Integer.parseInt(endTime.substring(0, 2))+Integer.parseInt(endTime.substring(3))*0.01;

//            List<Double> time = new ArrayList<>();
//            time.add(startD);
//            time.add(endD);
//            times.add(time);

//            times[cnt][0] = startD;
//            times[cnt][1] = endD;
//            cnt++;

            start.add(startD);
            end.add(endD);
        }


//        List<Double> list = new ArrayList<>();
        double value = 0.0;
        for(int i=0;i<start.size();i++){
            if(Objects.equals(st.peek(), start.get(i))){
//                list.add(end.get(i)+0.1);
                value = end.get(i)+0.1;
                start.remove(i);
                end.remove(i);
                break;
            }
        }
//        for(Double d: st){
//
//        }
//        while(start.size()>0){
//            for(int i=0;i<start.size();i++){
//                if(end<=(double)start.get(i)){
//                    list.remove(0);
//                    list.add(end.get(i)+0.1);
//                    start.remove(i);
//                    end.remove(i);
//                }
////                if(list.get(0)<=start.get(i)){
////                    list.remove(0);
////                    list.add(end.get(i)+0.1);
////                    start.remove(i);
////                    end.remove(i);
////                }
//            }
//            if(list.size()==1){
//                list.remove(0);
//                answer++;
//            }
//        }

        return answer;
    }

//    public void dfs(List<Double> list, ArrayList<Double> start,ArrayList<Double> end, Double d){
//        for(int i=0;i<start.size();i++){
//            if(list.get(list.size()-1)<=start.get(i)){
//                list.add(end.get(i)+0.1);
//                start.remove(i);
//                end.remove(i);
//                dfs(list,start,end,d);
//            }
//        }
//
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[][]{
                {"15:00", "17:00"},
                {"16:40", "18:20"},
                {"14:20", "15:20"},
                {"14:10", "19:20"},
                {"18:20", "21:20"}
        });
    }
}
