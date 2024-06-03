import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //스캐너 정의
        Scanner sc = new Scanner(System.in);
        //과목수 N
        int n = Integer.parseInt(sc.nextLine());
        //현제 성적 00 00 00 식으로
        // nextDouble 이 아닌 문자열로 받아 파싱하는 방법으로 접근
        String score = sc.nextLine();
        char[] cScore = score.toCharArray();
        double[] Score_arr = new double[n];
        int a = 0;
        int score_arr_num = 0;
        double sum = 0;
        char[] temp = {' ',' ',' '};
        for(int i =0; i< score.length();i++){
            if(cScore[i] != ' '){
                temp[a] = cScore[i];
                a++;
            }
            else if (cScore[i] == ' ' || (i==score.length()-1)){
                a = 0;
                //문제점
                //1. 문자 배열을 문자열로 바꾸기
                //2. 문자열을 인트로 바꾸기
                //3. temp에 포함되어있는 공백문자가 Int로 변환 시 문제가 되어 오류 발생
                //trim으로 공백 제거 하여 문제 해결
                // 최대값구하는 방식에서 Index로 찾으려해서 안된듯
                // 인덱스 말고 값으로 하면 됨 성공했던 코드보다 메모리 시간 적게 걸림
                Score_arr[score_arr_num]=Integer.parseInt(String.valueOf(temp).trim());
                for(int j = 0; j<3; j++){
                    //temp 초기화
                    temp[j] = ' ';
                }
                score_arr_num++;
            }
        }

        Score_arr[score_arr_num] = Integer.parseInt(String.valueOf(temp).trim());
        int max_idx=0;
        double max = 0;
        for(int i=0; i<n;i++){

            if (Score_arr[i]>max){
                max= Score_arr[i];
            }
        }
        for(int i=0;i<n;i++)
        {
            //Score_arr[i]=Score_arr[i]/Score_arr[max_idx]*100;
            sum +=Score_arr[i]/max*100;
        }

        System.out.println(sum/n);

    }

}