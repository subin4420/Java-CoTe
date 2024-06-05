package cote;

import java.util.*;

public class 평균 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        double avg;
        //최댓값 0으로 초기화
        double max = 0;
        int n = sc.nextInt();
        sc.nextLine();


        double[] score = new double[n];
        for (int i = 0; i < score.length; i++) {
            score[i] = sc.nextInt();

            //max 값과 비교해서 최대 score값 구함
            if (score[i] > max) {
                max = score[i];
            }
        }

        for (int i = 0; i < score.length; i++) {
            score[i] = (score[i] / max) * 100;
            sum += score[i];
        }

        avg = sum / n;
        System.out.println(avg);
    }
}
