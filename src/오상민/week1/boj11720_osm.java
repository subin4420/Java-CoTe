package Algorithm.bronze2;

import java.util.Scanner;

public class boj11720_osm {

  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    scanner.nextLine();
    String num = scanner.nextLine();

    int sum = 0;

    for(int i = 0; i < num.length();i++){
      sum+= num.charAt(i) - '0';// 아스키코드
    }
    System.out.println(sum);
  }
}
