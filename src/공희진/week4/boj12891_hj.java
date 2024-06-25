package algorithm;

import java.util.*;
import java.io.*;

//슬라이딩 윈도우 : 고정 사이즈의 윈도우가 이동하면서 윈도우 내에 있는 데이터를 이용해 문제를 풀이하는 알고리즘

public class boj12891_hj {

    // 최소로 필요한 A, C, G, T 개수를 저장할 배열
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // S: DNA 문자열의 길이, P: 부분 문자열의 길이
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // DNA 문자열 입력 받음
        String str = br.readLine();
        char[] pw = new char[S];
        // 전체 DNA 문자열에서 각 문자의 개수를 저장할 배열
        int[] dnaNum = new int[4];
        // 현재 슬라이딩 윈도우 내의 각 문자의 개수를 저장할 배열
        int[] currNum = new int[4];
        check = new int[4];
        int result = 0;

        // DNA 문자열을 순회하며 각 문자의 개수를 카운트
        for (int i = 0; i < S; i++) {
            pw[i] = str.charAt(i);
            if (pw[i] == 'A') dnaNum[0]++;
            if (pw[i] == 'C') dnaNum[1]++;
            if (pw[i] == 'G') dnaNum[2]++;
            if (pw[i] == 'T') dnaNum[3]++;
        }

        // 최소로 필요한 A, C, G, T의 개수 입력 받음
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        // 전체 DNA 문자열에서 최소 개수를 만족하지 못하면 결과를 출력하고 종료
        if (!checkNum(dnaNum)) {
            System.out.print(result);
            return;
        }

        // 첫 번째 슬라이딩 윈도우의 초기화 과정 (첫 번째 부분 문자열)
        for (int i = 0; i < P; i++) {
            if (pw[i] == 'A') currNum[0]++;
            if (pw[i] == 'C') currNum[1]++;
            if (pw[i] == 'G') currNum[2]++;
            if (pw[i] == 'T') currNum[3]++;
        }
        // 초기화된 부분 문자열이 조건을 만족하면 결과 증가
        if (checkNum(currNum)) result++;

        // 슬라이딩 윈도우 방식으로 문자열을 순회하며 조건을 만족하는지 체크
        for (int j = P; j < S; j++) { // j는 슬라이딩 윈도우의 뒷부분 인덱스
            int i = j - P; // i는 슬라이딩 윈도우의 앞부분 인덱스

            // 슬라이딩 윈도우의 앞부분을 빼고 뒷부분을 더함
            if (pw[i] == 'A') currNum[0]--;
            if (pw[i] == 'C') currNum[1]--;
            if (pw[i] == 'G') currNum[2]--;
            if (pw[i] == 'T') currNum[3]--;

            if (pw[j] == 'A') currNum[0]++;
            if (pw[j] == 'C') currNum[1]++;
            if (pw[j] == 'G') currNum[2]++;
            if (pw[j] == 'T') currNum[3]++;

            // 현재 슬라이딩 윈도우가 조건을 만족하면 결과 증가
            if (checkNum(currNum)) result++;
        }

        // 최종 결과 출력
        System.out.print(result);
    }

    // 주어진 배열의 값이 최소 조건을 만족하는지 체크하는 함수
    public static boolean checkNum(int[] num) {
        for (int i = 0; i < 4; i++) {
            if (num[i] < check[i])
                return false;
        }
        return true;
    }
}
