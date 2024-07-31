package algorithm.graph;

public class 타겟넘버 {
    public static int answer;
    public static int[] booho = {-1, 1};

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target,0, 0);

        return answer;
    }

    public static void dfs(int[] numbers, int target, int curr, int depth) {
        if(depth == numbers.length) {
            if(curr == target) {
                answer++;
            }
            return;
        }

        dfs(numbers, target, curr + numbers[depth], depth+1 );
        dfs(numbers, target, curr - numbers[depth], depth+1);
    }
}
