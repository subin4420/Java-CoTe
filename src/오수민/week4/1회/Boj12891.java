import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        st = new StringTokenizer(br.readLine());

        int[] numArr = new int[4];
        int nums = 0;
        int answer = 0;

        for (int i = 0; i < 4; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
            nums += numArr[i];
        }

        String[] strArr = str.split("");
        int[] intArr = new int[4];
        for (int i = 0; i < S; i++) {
            if (strArr[i].equals("A")) intArr[0]++;
            else if (strArr[i].equals("C")) intArr[1]++;
            else if (strArr[i].equals("G")) intArr[2]++;
            else if (strArr[i].equals("T")) intArr[3]++;
        }

        if (nums > P) {
            System.out.println(answer);
            return;
        }
        for (int i = 0; i < numArr.length; i++) {
            if (intArr[i] < numArr[i]) {
                System.out.println(answer);
                return;
            }
        }

//        시간초과
//        int s_i = 0;
//        while(s_i<=strArr.length-P){
//            int[] tmpArr = new int[4];
//            for (int s = s_i; s < s_i+P; s++) {
//                if (strArr[s].equals("A")) tmpArr[0]++;
//                else if (strArr[s].equals("C")) tmpArr[1]++;
//                else if (strArr[s].equals("G")) tmpArr[2]++;
//                else if (strArr[s].equals("T")) tmpArr[3]++;
//            }
//            if(tmpArr[0]>=numArr[0]&&tmpArr[1]>=numArr[1]&&tmpArr[2]>=numArr[2]&&tmpArr[3]>=numArr[3]){answer++;}
//            s_i++;
//        }


//        통과
        int s_i = 0;
        int[] tmpArr = new int[4];
        for (int s = s_i; s < s_i + P; s++) {
            if (strArr[s].equals("A")) tmpArr[0]++;
            else if (strArr[s].equals("C")) tmpArr[1]++;
            else if (strArr[s].equals("G")) tmpArr[2]++;
            else if (strArr[s].equals("T")) tmpArr[3]++;
        }
//        이 부분을 중복되지 않게 한번만 하고 싶음
        if (tmpArr[0] >= numArr[0] && tmpArr[1] >= numArr[1] && tmpArr[2] >= numArr[2] && tmpArr[3] >= numArr[3]) {
            answer++;
        }
        while (s_i < strArr.length - P) {
            if (strArr[s_i].equals("A")) tmpArr[0]--;
            else if (strArr[s_i].equals("C")) tmpArr[1]--;
            else if (strArr[s_i].equals("G")) tmpArr[2]--;
            else if (strArr[s_i].equals("T")) tmpArr[3]--;

            int end = s_i+P;
            if (strArr[end].equals("A")) tmpArr[0]++;
            else if (strArr[end].equals("C")) tmpArr[1]++;
            else if (strArr[end].equals("G")) tmpArr[2]++;
            else if (strArr[end].equals("T")) tmpArr[3]++;

            if (tmpArr[0] >= numArr[0] && tmpArr[1] >= numArr[1] && tmpArr[2] >= numArr[2] && tmpArr[3] >= numArr[3]) {
                answer++;
            }
            s_i++;
        }

        System.out.println(answer);

    }
}

