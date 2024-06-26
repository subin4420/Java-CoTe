import java.util.Scanner;

public class boj12891_bgm_fail {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();
        String s = sc.next();
        int[] acgt = {2, 0, 1, 1};
        int[] check = new int[acgt.length];

        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == 'A') {
                check[0]++;
            } else if (charArr[i] == 'C') {
                check[1]++;
            } else if (charArr[i] == 'G') {
                check[2]++;
            } else if (charArr[i] == 'T') {
                check[3]++;
            }
        }
        for (int i = 0; i < check.length; i++) {
            if (check[i] >= acgt[i]) {

            } else {
                System.out.println(0);
            }
        }
    }
}
