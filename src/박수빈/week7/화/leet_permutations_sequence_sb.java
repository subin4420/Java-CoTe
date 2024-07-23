package algo0712;

public class permutations_sequence {
    //n의 순열을 만들어 그 중 k번 째 리턴하기
    class Solution {
        public String getPermutation(int n, int k) {
            int[] orders = new int[n + 1];
            search(orders, n, k, 0, 0);
            return buildStringFromOrder(n, orders);
        }

        String buildStringFromOrder(int n, int[] orders) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (orders[j] == i + 1) {
                        sb.append((char)(48 + j));
                    }
                }
            }
            return sb.toString();
        }
        //미리 팩토리얼 계산해놓기 1부터 9까지
        int[] factorial = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

        void search(int[] orders, int n, int k, int order, int count) {
            //k를 통해 순열의 자리별 어떤 수가 사용되는지 계산가능 첫 (n-1)!개로 나눈
            for (int i = 1; i <= n; i++) {
                if (orders[i] != 0) continue;
                if (k > count + factorial[n - order - 1]) {
                    count += factorial[n - order - 1];
                    continue;
                }
                orders[i] = order + 1;
                search(orders, n, k, order + 1, count);
                break;
            }
        }
    }
}
