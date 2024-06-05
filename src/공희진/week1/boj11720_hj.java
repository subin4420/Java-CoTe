package cote;
import java.util.Scanner;
public class 숫자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();

        String str = sc.nextLine();
        //str을 char형안 배열로 저장
        char[] cNum = str.toCharArray();
        int sum = 0;

        //char형을 int형으로 변환하여 sum값 구함
        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0';
        }

        System.out.println(sum);
    }
}
