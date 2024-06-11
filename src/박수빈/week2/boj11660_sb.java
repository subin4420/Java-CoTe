import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //스캐너 정의
        Scanner sc = new Scanner(System.in);
        //과목수 N
        /* psudo code
        *
        * */
       int N = sc.nextInt();
       int M = sc.nextInt();
       int[][] arr = new int[N][N];
       int[][] sum = new int[N+1][N+1];
       int[] result = new int[M];
       int[] xy = new int[4];
        //2차원 배열 받기
        for(int i=0;i<N;i++){
            for( int j=0; j<N;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        //2차원 배열에 sum 배열 만들기
       for(int i=0;i<N+1;i++){
           for( int j=0; j<N+1;j++){
                if(i==0){
                    sum[i][j] = 0;
                }
                else if(j==0){
                    sum[i][j] = 0;
                }
                else{
                    sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+arr[i-1][j-1];
                }
           }
       }
       for(int i=0;i<M;i++){
            for(int j=0;j<4;j++){
                xy[j] = sc.nextInt();
            }
            //xy[0] = x1 xy[1]= y1 xy[2]= x2 xy[3]= y2
           // sum[x2][y2]-(sum[x1-1][y2]+sum[x2][y1-1]-sum[x1-1][y1-1])
            result[i]=sum[xy[2]][xy[3]]-(sum[xy[2]][xy[1]-1]+sum[xy[0]-1][xy[3]]-sum[xy[0]-1][xy[1]-1]);

       }


//        for(int i=0;i<N+1;i++){
//            for( int j=0; j<N+1;j++){
//                System.out.print(sum[i][j]);
//                System.out.print(" ");
//
//            }
//            System.out.println();
//        }


        for(int i=0;i<M;i++){
            System.out.println(result[i]);
        }
    }


}