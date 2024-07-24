import java.util.*;

class Solution {
    
    List<Integer> list = new ArrayList<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            dfs(numbers, "", i + 1);
        }
        return list.size();
    }
    
    public void dfs(String str, String tmp, int len) {
        if (tmp.length() == len) {
            int num = Integer.parseInt(tmp);
            if (!list.contains(num) && isPrime(num)) {
                list.add(num);
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp += str.charAt(i);
                dfs(str, tmp, len);
                tmp = tmp.substring(0, tmp.length() - 1);
                visited[i] = false;
            }
        }
        
    }
    
    public boolean isPrime(int num) {
        if (num < 2) return false;
        int i = 2;
        while (i * i <= num) {
            if (num % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
    
}