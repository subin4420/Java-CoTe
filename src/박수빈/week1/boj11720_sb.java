import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //스캐너 정의
        Scanner sc = new Scanner(System.in);
        //첫 입력 다음 입력 받을 문자열의 길이
        int len=Integer.parseInt(sc.nextLine());
        //숫자들의 나열인 문자열을 입력받는다.
        String num_str = sc.nextLine();

        //int[] num_arr = new int[len];
        int sum = 0;
        //문자열 길이 만큼 반복
        for(int i= 0; i<len; i++){
            //입력받은 문자열의 해당 인덱스의 문자를 반환해 정수형으로 변경
            sum = sum + Character.getNumericValue(num_str.charAt(i));
        }
// 각 문자에 접근
        System.out.println(sum);
    }

}