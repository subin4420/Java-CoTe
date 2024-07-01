package Programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class pgs_같은숫자는싫어 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4};
        int[] answer = IntStream.range(0, arr.length)   // 0부터 arr.length - 1까지의 인덱스 스트림 생성
                .filter(i -> i == 0 || arr[i] != arr[i-1])  // 0번째 인덱스 또는 연속되지 않은 인덱스를 필터링
                .map(i -> arr[i])  // 필터링된 인덱스를 배열의 값으로 매핑  *필터링 된 값을 사용하려면 map을 써야함*
                .toArray(); // 스트림을 배열로 변환
        System.out.println(Arrays.toString(answer));
    }
}
