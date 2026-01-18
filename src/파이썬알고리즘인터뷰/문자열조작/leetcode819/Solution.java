package 파이썬알고리즘인터뷰.문자열조작.leetcode819;

import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        String newParagraph = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase();
        Map<String, Integer> counter = new HashMap<>();
        for (String word : newParagraph.split("\\s+")) {
            if (!bannedSet.contains(word)) {
                counter.put(word, counter.getOrDefault(word, 0) + 1);
            }
        }

        String result = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry: counter.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
    }
}
