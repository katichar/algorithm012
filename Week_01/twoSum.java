

时间复杂度 O(n)
思路：用map替代嵌套循环 containsKey
借用语言中的数据结构类，也是一种解题思路
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}

两数之和
https://leetcode-cn.com/problems/two-sum/
