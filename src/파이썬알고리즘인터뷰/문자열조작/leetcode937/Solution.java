package 파이썬알고리즘인터뷰.문자열조작.leetcode937;

import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            String[] split = log.split(" ", 2);
            if (Character.isLetter(split[1].charAt(0))) {
                letterLogs.add(log);
            } else if (Character.isDigit(split[1].charAt(0))) {
                digitLogs.add(log);
            }
        }

        letterLogs.sort(new LetterLogComparator());
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

class LetterLogComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] split1 = o1.split(" ", 2);
        String[] split2 = o2.split(" ", 2);

        int cmp = split1[1].compareTo(split2[1]);
        if (cmp != 0) {
            return cmp;
        }
        return split1[0].compareTo(split2[0]);
    }
}