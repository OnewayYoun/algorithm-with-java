package 파이썬알고리즘인터뷰.문자열조작.leetcode005;

class Solution {
    public String longestPalindrome(String s) {
        if (isPalindrome(s)) {
            return s;
        }

        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String result1 = expand(s, i, i);
            String result2 = expand(s, i, i + 1);
            if (result1.length() > result.length()) {
                result = result1;
            }
            if (result2.length() > result.length()) {
                result = result2;
            }
        }
        return result;
    }

    public String expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] arg) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }
}