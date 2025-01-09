package LeetCode.Top150.Hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    /*
    Input: nums = [100,4,200,1,3,2]
    Output: 4

    Input: nums = [0,3,7,2,5,8,4,6,0,1]
    Output: 9
    */
    static class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            int answer = 0;
            for (Integer num : numsSet) {
                if (!numsSet.contains(num - 1)) {
                    int n = 0;
                    while (numsSet.contains(num + n)) {
                        n++;
                    }
                    answer = Math.max(answer, n);
                }
            }
            return answer;
        }

        public static void main(String[] args) {
            LongestConsecutiveSequence.Solution solution = new LongestConsecutiveSequence.Solution();
            int[] nums = {100, 4, 200, 1, 3, 2, 2};
            System.out.println(solution.longestConsecutive(nums));
        }
    }
}
