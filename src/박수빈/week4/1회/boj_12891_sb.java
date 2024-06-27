package boj;

import java.util.Scanner;
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int str_len = sc.nextInt();
        int substr_len = sc.nextInt();
        sc.nextLine();
        String a =sc.nextLine();
        char[] str = a.toCharArray();
        int[] ACGT = new int[4];
        for (int i = 0; i < 4; i++) {
            ACGT[i] = sc.nextInt();
        }
        int cnt = 0;
        int[] now_ACGT = new int[]{0,0,0,0};

        Queue<Character> q = new LinkedList<>();
        //초기 윈도우 설정
        for (int i = 0; i < substr_len; i++){
            char ch = str[i];
            q.add(str[i]);
            addCharCount(ch, now_ACGT);
        }
        //System.out.println(q);

        if(checkQ(q, ACGT)){
            cnt++;
            //System.out.println(cnt);
        }
//        for (int i = substr_len; i < str_len; i++) {
//            //char removeedChar = q.poll();
//            q.add(str[i]);
//            //System.out.println(q);
//            if(checkQ(q, ACGT)){
//                cnt++;
//                //System.out.println(cnt);
//
//            }
//        }

        for (int i = substr_len; i < str_len; i++) {
            char removedChar = q.poll();
            removeCharCount(removedChar, now_ACGT);
            char newChar = str[i];
            q.add(str[i]);
            addCharCount(newChar, now_ACGT);

            //System.out.println(q);
            if(checkCount(now_ACGT, ACGT)){
                cnt++;
                //System.out.println(cnt);

            }
        }

        System.out.println(cnt);



    }
    private static void addCharCount(char ch, int[] now_ACGT) {
        switch (ch) {
            case 'A': now_ACGT[0]++; break;
            case 'C': now_ACGT[1]++; break;
            case 'G': now_ACGT[2]++; break;
            case 'T': now_ACGT[3]++; break;
        }
    }
    private static void removeCharCount(char ch, int[] now_ACGT) {
        switch (ch) {
            case 'A': now_ACGT[0]--; break;
            case 'C': now_ACGT[1]--; break;
            case 'G': now_ACGT[2]--; break;
            case 'T': now_ACGT[3]--; break;
        }
    }
    private static boolean checkCount(int[] now_ACGT, int[] ACGT) {
        for (int i = 0; i < 4; i++) {
            if (now_ACGT[i] < ACGT[i]) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkQ(Queue<Character> q,int[] ACGT){
        List<Character> list = new ArrayList<>(q);
        int[] now_ACGT = new int[]{0,0,0,0};
        for (int i = 0; i < q.size(); i++) {
            if(list.get(i) == 'A'){
                now_ACGT[0]++;
            }
            else if(list.get(i) == 'C'){
                now_ACGT[1]++;
            }
            else if(list.get(i) == 'G'){

                now_ACGT[2]++;
            }
            else if(list.get(i) == 'T') {
                now_ACGT[3]++;
            }
        }
        for (int i = 0; i < 4; i++) {
            if(now_ACGT[i] < ACGT[i]){
                return false;
            }
        }

        return true;
    }
}
