盛最多水的容器
https://leetcode-cn.com/problems/container-with-most-water/submissions/


1：枚举法
时间复杂度 O(n^2)
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length-1; ++i) {
            for (int j = i+1; j < height.length; ++j) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(area,max);
            }
        }
        return max;
    }
}


2：双指针法
时间复杂度 O(n)
左右边界同时向中间收
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length-1; i < j;) {
            int minH = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i +1) * minH;
            max = Math.max(area,max);
        }
        return max;
    }
}