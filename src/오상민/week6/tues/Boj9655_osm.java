import java.util.Scanner;

/**
 * 돌 게임
 * 1    sk                      sk
 * 2    sk cy                   cy
 * 3    3sk                     sk
 * 4    sk 3cy                  cy
 * 5    sk cy 3sk               sk
 * 6    sk cy sk 3cy            cy
 * 7
 * 8
 * 9
 * 10   sk cy sk cy sk cy 3sk 3cy
 * 3남으면 이김
 */
public class Boj9655_osm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (N % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}