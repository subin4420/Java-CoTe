package Stack;

import java.util.ArrayList;

public class Prgm12906 {
    public static void main(String[] args) {
        int []arr = {1,1,3,3,0,1,1};
        ArrayList<Integer> al = new ArrayList<>();

        int tmp = arr[0];
        al.add(tmp);
        for(int i=1;i<arr.length;i++){
            if(tmp!=arr[i]){
                al.add(arr[i]);
                tmp = arr[i];
            }
        }

        // Arraylist를 int[]로 반환하는 방법은 이렇게 밖에 없나?
        Integer[] iarr = al.toArray(new Integer[0]);
        int[] answer = new int[iarr.length];

        for(int i=0;i<iarr.length;i++){
            answer[i] = iarr[i];
        }
    }
}
