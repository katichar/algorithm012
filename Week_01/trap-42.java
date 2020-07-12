积水只能在低洼处形成，当后面的柱子高度比前面的低时，是无法接雨水的。所以使用单调递减栈储存可能储水的柱子，当找到一根比前面高的柱子，就可以计算接到的雨水。
时间复杂度 O(n)
空间复杂度 O(n)
栈解法
class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<Integer>();
        int i = 0;
        int len = height.length;
        int ans = 0;
        while (i < len) {
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int top = st.pop();
                if(st.isEmpty()) break;
                int distance = i - st.peek() - 1;
                int boundH = Math.min(height[i],height[st.peek()]) - height[top];
                ans = ans + boundH * distance;
            }
            st.push(i++);
        }
        return ans;
    }
}

--双指针解法