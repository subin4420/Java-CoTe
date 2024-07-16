import java.util.ArrayList;
import java.util.List;

public class leet_permutationSequence_bgm {
    public static void main(String[] args) {
        // 예제 List<List<Integer>> 생성
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sublist1 = new ArrayList<>();
        sublist1.add(1);
        sublist1.add(2);
        sublist1.add(3);
        result.add(sublist1);

        List<Integer> sublist2 = new ArrayList<>();
        sublist2.add(4);
        sublist2.add(5);
        sublist2.add(6);
        result.add(sublist2);

        // k번째 인덱스를 문자열로 변환
        int k = 1; // 변환할 인덱스 값
        for (List<Integer> sublist : result) {
            if (k < sublist.size()) {
                String stringValue = String.valueOf(sublist.get(k));
                System.out.println("Before conversion: " + sublist);
                sublist.set(k, Integer.parseInt(stringValue)); // 실제로 변환하지 않고 출력만
                System.out.println("After conversion of index " + k + ": " + stringValue);
            }
        }
    }
}
