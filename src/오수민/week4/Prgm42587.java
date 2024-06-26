package Stack;

//원형큐를 이용해서 이미 0으로 바뀐 부분은 연산을 안하고 넘어가는 방식으로 구현하고 싶었는데 실패함
public class Prgm42587 {
    public static void main(String[] args) {
        int answer = 0;
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        int[] rank = new int[priorities.length];
        int ranking = 1;
        int max = 0, max_i = 0;
        int cnt = 0;
        int start = 0;
        while (cnt<priorities.length) {
            max = 0;
            for(int i=0;i<priorities.length;i++){
                if(max<priorities[start]){
                    max = priorities[start];
                    max_i = start;
                }
                start++;
                start %= priorities.length;
            }
            rank[max_i] = ranking++;
            priorities[max_i] = 0;
            start = max_i;
            cnt++;
        }
        answer = rank[location];
        System.out.println(answer);
    }
}
