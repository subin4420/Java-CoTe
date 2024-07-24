package week6;

import java.util.Scanner;

public class Boj9655_sm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int i = N;
        int cnt = 0;

        while(i>0){
            if(i>3){
                i-=3;
            }
            else{
                i-=1;
            }
            cnt++;
        }
        System.out.println(cnt%2==0?"CY":"SK");
    }
}
