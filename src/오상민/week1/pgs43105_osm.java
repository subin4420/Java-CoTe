import java.util.*;
class Solution {
  public int solution(int[][] triangle) {
    int answer = 0;
    for(int i=1; i<triangle.length; i++){
      int len = triangle[i].length;
      for(int j=0; j<len; j++){
        if(j == 0) {
          triangle[i][j] += triangle[i-1][0];
        }else if(j == len-1){
          triangle[i][j] += triangle[i-1][j-1];
        }else{
          triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }
      }
    }
    answer = Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    return answer;
  }
}