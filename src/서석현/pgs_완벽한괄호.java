package Programmers;

public class pgs_완벽한괄호 {
    public static boolean solution(String s) {
        int count = 0;

//        char c : s.toCharArray() 예시 :
//
//        String s = "Hello";
//        for (char c : s.toCharArray()) {
//            System.out.println(c);
//        }
//        문자열 "Hello"는 toCharArray() 메서드를 통해 ['H', 'e', 'l', 'l', 'o'] 문자 배열로 변환되어 c에 저장되고,
//        for-each 루프는 각 문자를 하나씩 출력합니다.

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}