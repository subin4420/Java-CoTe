package cote0709;

import java.util.Scanner;
//돌게임 완

public class Q2 {
    class q1{

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0) {
            System.out.println("CY");
        }
        else{
            System.out.println("SK");
        }
    }
}
