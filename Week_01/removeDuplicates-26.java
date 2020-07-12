26. 删除排序数组中的重复项
双指针解法1：慢指针i为不重复下标，快指针k为遍历数组下标，当找到不同时i++
时间复杂度: O(n)
空间复杂度O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != nums[i]) {
                i++;
                nums[i] = nums[k];
            }
        }
        return i + 1;
    }
}

双指针解法2:c:统计重复项 len-c：不重复数据长度；
时间复杂度: O(n)
空间复杂度O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int c = 0;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if(nums[i] == nums[i-1]) {
                c++;
            }else{
                nums[i-c] = nums[i];
            }
        }
        return len - c;
    }
}
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/