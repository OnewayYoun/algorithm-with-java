package 파이썬알고리즘인터뷰.문자열조작.leetcode937;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs= new ArrayList<>();
        List<String> digitLogs= new ArrayList<>();
        for (String s: logs) {
            String[] log = s.split(" ");
            if (Character.isAlphabetic(log[1].charAt(0))) {
                letterLogs.add(s);
            } else {
                digitLogs.add(s);
            }
        }
        Collections.sort(letterLogs, (a, b) ->{
            String[] splitA = a.split(" ", 2);
            String[] splitB = b.split(" ", 2);

            int cmp = splitA[1].compareTo(splitB[1]);
            if (cmp == 0) {
                return splitA[0].compareTo(splitB[0]);
            }
            return cmp;
        });

        List<String> result = new ArrayList<>();
        result.addAll(letterLogs);
        result.addAll(digitLogs);

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"});
    }
}
