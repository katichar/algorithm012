

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


数组解法：数组变量初始为26个字，遍历1字符每个字符与‘a’蒫 值并+1，遍历2字符每个字符与‘a’蒫 值并-1，最后遍历变量数组，如果存在不为0的值，则为false

时间复杂度 o(2n)
空间复杂度 0（1）
public boolean isAnagram(String s, String t) {
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
        count[c - 'a'] += 1;
    }
    for (char c : t.toCharArray()) {
        count[c - 'a'] -= 1;
    }
    for (int i = 0; i < 26; i++) {
        if(count[i]!=0) return false;
    }
    return true;
}
两数之和
https://leetcode-cn.com/problems/two-sum/
