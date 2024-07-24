/**
 * 소수 찾기
 */

import java.util.*;

class Solution {
    int answer = 0;
    HashSet<Integer> prime;
    boolean[] visited;

    boolean isPrime(int x) {
        if (x < 2) return false;

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    void dfs(boolean[] visited, int current, String numbers, int length) {
        if (numbers.length() == length) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                int newValue = current + (int) ((numbers.charAt(i) - '0') * Math.pow(10, length));
                prime.add(newValue);
                dfs(visited, newValue, numbers, length + 1);
                visited[i] = false;
            }
        }
    }

    public int solution(String numbers) {
        prime = new HashSet<Integer>();
        visited = new boolean[numbers.length()];
        dfs(visited, 0, numbers, 0);

        for (int x : prime) {
            if (isPrime(x)) answer++;
        }

        return answer;
    }
}