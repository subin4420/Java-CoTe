import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Pgs132265_sm {
    public static void main(String[] args) {
//        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int[] topping = {1, 2, 3, 1, 4};

        int answer = 0;

        int[] l = new int[topping.length];
        int[] r = new int[topping.length];

        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < topping.length; i++){
            set.add(topping[i]);
            l[i] = set.size();
        }
        set.clear();
        for(int i = topping.length-1; i>=0; i--){
            set.add(topping[i]);
            r[i] = set.size();
        }

        for(int i = 0; i < topping.length-1; i++){
            if(l[i] == r[i+1]){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
