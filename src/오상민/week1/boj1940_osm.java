import java.util.Arrays;
import java.util.Scanner;

public class boj1940_osm {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int M = scanner.nextInt();
    int arr[] = new int[N];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scanner.nextInt();
    }
    Arrays.sort(arr);

    int startIdx = 0;
    int endIdx = N-1;
    int cnt = 0;

    while (startIdx < endIdx) {
      int sum = arr[startIdx] + arr[endIdx];
      if (sum == M) {
        cnt++;
        endIdx--;
        startIdx++;
      } else if (sum < M) {
        startIdx++;
      } else {
        endIdx--;
      }
    }
    System.out.println(cnt);
  }
}