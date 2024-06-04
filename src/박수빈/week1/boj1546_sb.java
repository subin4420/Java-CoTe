import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //스캐너 정의
        Scanner sc = new Scanner(System.in);
        //과목수 N
        double sum = 0;
        int n = Integer.parseInt(sc.nextLine());
        //현제 성적 받아오기
        double[] Score_arr = new double[n];
        //int max_idx = 0;
        for(int i=0; i<n; i++){
            Score_arr[i] = sc.nextDouble();
        }
        double max = 0;
        for(int i=0; i<n; i++){
            if(Score_arr[i]>max){
                max = Score_arr[i];
            }
        }
        for(int i=0; i<n; i++){
            sum+=(Score_arr[i]/max)*100;
        }



        System.out.println(sum/n);


    }

}