package 파이썬알고리즘인터뷰.문자열조작.leetcode125;


import java.util.stream.IntStream;

class Solution {
    public boolean isPalindrome(String s) {
        String newString = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        if (newString.length() <= 1) {
            return true;
        }
        return IntStream.range(0, newString.length() / 2).allMatch(i -> newString.charAt(i) == newString.charAt(newString.length() - i - 1));
    }

    public boolean isPalindrome1(String s) {
        String newString = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = newString.length() - 1;

        while (left < right) {
            if (newString.charAt(left) != newString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("0z;z   ; 0"));
    }
}