class Solution {
    public int solution(String s) {
        String tmp = "";
        String result = "";
        String[] arr = {"zero", "one", "two", "three", "four", "five",
        "six","seven","eight", "nine"};
        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(arr[i], i + "");
        }
        return Integer.parseInt(s);
    }
}