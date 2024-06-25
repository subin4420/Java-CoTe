import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        System.out.println(fibo(n));
// 메모리 초과
//        long[] F = new long[n+1];
//        F[0] = 0;
//        F[1] = 1;
//        for (int i = 2; i < n+1; i++) {
//            F[i]=F[i-2]+F[i-1];
//        }
//        System.out.println(F[n]);

//        long a = 0;
//        long b = 1;
//        long c=0;
//
//        if(n==0)
//            System.out.println(a);
//        else if(n==1)
//            System.out.println(b);
//        else{
//            for (int i = 2; i <= n; i++) {
//                //한칸씩 뒤로 밀어 버린다.
//                c= a+b;
//                a=b;
//                b=c;
//            }
//            System.out.println(c);
//        }

        // Edge cases for 0 and 1
        if (n == 0) {
            System.out.println(0);
            return;
        } else if (n == 1) {
            System.out.println(1);
            return;
        }

        // Using BigInteger to handle very large Fibonacci numbers
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ZERO;

        for (int i = 2; i <= n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }

        System.out.println(c);


    }

    public static int fibo(int n){

        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
       return fibo(n-1)+fibo(n-2);

    }

}
