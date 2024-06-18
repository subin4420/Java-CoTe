import java.util.Scanner;

public class boj2018_osm {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int answer = 0;

    for(int i=1; i<=n; i++){
      int sum = 0;
      for(int j=i; j<=n; j++){
        sum+=j;
        if(sum >n) break;
        else if(sum == n){
          answer++;
          break;
        }
      }
    }
    System.out.println(answer);
  }
}
