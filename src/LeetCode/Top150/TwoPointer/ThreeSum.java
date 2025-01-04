package LeetCode.Top150.TwoPointer;

import java.util.*;

public class ThreeSum {
    public static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<Integer> newList = new ArrayList<>();
            Map<Integer, Integer> countMap = new HashMap<>();

            for (int num : nums) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();
                for (int i = 0; i < Math.min(val, 3); i++) {
                    newList.add(key);
                }
            }

            Set<List<Integer>> answer = new HashSet<>();

            for (int idx = 0; idx < newList.size(); idx++) {
                Map<Integer, Integer> dd = new HashMap<>();
                for (int i = 0; i < newList.size(); i++) {
                    if (i == idx) {
                        continue;
                    }
                    int target = -newList.get(idx) - newList.get(i);
                    if (dd.containsKey(target)) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(newList.get(idx));
                        triplet.add(newList.get(i));
                        triplet.add(newList.get(dd.get(target)));
                        Collections.sort(triplet);
                        answer.add(triplet);
                    }
                    dd.put(newList.get(i), i);
                }
            }

            return new ArrayList<>(answer);
        }
    }
}
