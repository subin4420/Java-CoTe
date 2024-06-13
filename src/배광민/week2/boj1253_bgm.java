import java.util.Arrays;
import java.util.Scanner;

public class boj1253_bgm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        int target[] = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = sc.nextInt();
        }

        Arrays.sort(target);
        for (int k = 0; k < n; k++) {
            int good = target[k];
            int i = 0;
            int j = n - 1;

            while (i < j) {
                if (target[i] + target[j] == good) {
                    if (i != k && j != k) {
                        good++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (target[i] + target[j] < good) {
                    i++;
                } else {
                    j--;
                }
            }
            System.out.println(good);
        }
    }
}
