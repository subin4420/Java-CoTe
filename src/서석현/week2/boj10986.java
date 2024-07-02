import java.util.Scanner;

public class boj10986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        // 나머지를 카운트할 배열
        long[] modCount = new long[m];
        long prefixSum = 0;
        long count = 0;

        // 나머지가 0인 경우 미리 포함
        modCount[0] = 1;

        for (int i = 0; i < n; i++) {
            prefixSum = (prefixSum + array[i]) % m;
            if (prefixSum < 0) {
                prefixSum += m; // 나머지가 음수가 되지 않도록 조정
            }
            count += modCount[(int)prefixSum];
            modCount[(int)prefixSum]++;
        }

        System.out.println(count);

        sc.close();
    }
}
