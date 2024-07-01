package BaeJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12891 {
    static int checkArr[];
    static int myArr[];
    static int check;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int result = 0;
        char a[] = new char[s];
        checkArr = new int[4];
        myArr = new int[4];
        check = 0;

        a = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken()); // 목표로 하는 각 문자의 최소 개수 입력
            if(checkArr[i] == 0) // 최소 개수가 0인 경우 바로 조건 충족
                check++;
        }

        // 초기 p 길이 부분 문자열 처리 부분
        for (int i = 0; i < p; i++) {
            add(a[i]); // 초기 부분 문자열의 각 문자를 추가
        }
        if (check == 4) // 모든 목표 조건을 만족하면 결과 증가
            result++;

        // 슬라이딩 윈도우 처리 부분
        for (int i = p; i < s; i++) {
            int j = i - p; // 슬라이딩 윈도우의 시작 인덱스
            add(a[i]); // 새로운 문자를 추가
            remove(a[j]); // 이전 문자를 제거
            if(check == 4) // 모든 목표 조건을 만족하면 결과 증가
                result++;
        }
        System.out.println(result); // 최종 결과 출력
        bf.close(); // BufferedReader 닫기
    }

    // 문자를 추가하는 메소드
    private static void add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++; // 'A' 문자의 개수 증가
                if (myArr[0] == checkArr[0]) // 목표 개수와 일치하면 조건 충족
                    check++;
                break;
            case 'C':
                myArr[1]++; // 'C' 문자의 개수 증가
                if (myArr[1] == checkArr[1]) // 목표 개수와 일치하면 조건 충족
                    check++;
                break;
            case 'G':
                myArr[2]++; // 'G' 문자의 개수 증가
                if (myArr[2] == checkArr[2]) // 목표 개수와 일치하면 조건 충족
                    check++;
                break;
            case 'T':
                myArr[3]++; // 'T' 문자의 개수 증가
                if (myArr[3] == checkArr[3]) // 목표 개수와 일치하면 조건 충족
                    check++;
                break;
        }
    }

    // 문자를 제거하는 메소드
    private static void remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) // 제거 전에 목표 개수와 일치하면 조건 충족 해제
                    check--;
                myArr[0]--; // 'A' 문자의 개수 감소
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) // 제거 전에 목표 개수와 일치하면 조건 충족 해제
                    check--;
                myArr[1]--; // 'C' 문자의 개수 감소
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) // 제거 전에 목표 개수와 일치하면 조건 충족 해제
                    check--;
                myArr[2]--; // 'G' 문자의 개수 감소
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) // 제거 전에 목표 개수와 일치하면 조건 충족 해제
                    check--;
                myArr[3]--; // 'T' 문자의 개수 감소
                break;
        }
    }
}
