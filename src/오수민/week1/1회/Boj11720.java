import java.util.*;

public class Boj11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //합할 숫자의 개수 입력받음
        
        String sNum = sc.next(); //N개의 숫자 입력
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for(int i=0;i<N;i++){
            sum += cNum[i]-'0'; //아스키코드에서 문자0을빼주면 정수형으로 변환됨
        }
        System.out.println(sum);
    }
}
