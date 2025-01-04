package LeetCode.Top150.Hashmap;

import java.util.*;

public class TwoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] {map.get(complement), i};
                }
                map.put(nums[i], i);
            }

            return new int[] {};
        }

        public static void main(String[] args) {
            Solution solution = new Solution();

            int[] nums1 = {2, 7, 11, 15};
            int target1 = 9;
            System.out.println(Arrays.toString(solution.twoSum(nums1, target1)));
        }
    }
}
