package cote.three;

import java.util.*;

public class pgs155651_sm {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time,(x,y)->x[0].compareTo(y[0]));
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]); //대실시간이 가장짧은 거 먼저

        //예약 시간 정수로 변경
        int[][] time = new int[book_time.length][2];
        for(int i=0;i<book_time.length;i++){
            int start_time = Integer.parseInt(book_time[i][0].replace(":",""));
            int end_time = Integer.parseInt(book_time[i][1].replace(":",""));

            end_time+=10;
            if(end_time%100>=60){
                end_time+=40;
            }
            time[i][0]=start_time;
            time[i][1]=end_time;
        }

        //예약 시간별로 객실 할당
        ArrayList<Integer> rooms = new ArrayList<>();
        for(int i=0;i<time.length;i++){
            Collections.sort(rooms);

            boolean isAdd=false; //객실 할당되었는지 확인

            for(int j=0;j<rooms.size();j++){
                //이미 할당된 객실 중에 현재 사용 가능한 객실이 있다면, 할당
                if(time[i][0] >= rooms.get(j)){
                    rooms.set(j,time[i][1]);
                    isAdd=true;
                    break;
                }
            }

            if(!isAdd){
                //이미 할당된 객실 중에 현재 사용 가능한 객실이 없다면, 새로 할당
                rooms.add(time[i][1]);
            }
        }
        return rooms.size();
    }
}
