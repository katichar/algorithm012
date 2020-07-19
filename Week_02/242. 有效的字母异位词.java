
排序后比较是否，借用数据排序函数
时间复杂度 o(nlogn) 排序成本 O(n\log n)O(nlogn) 和比较两个字符串的成本 O(n)O(n)。排序时间占主导地位，总体时间复杂度为 O(n \log n)O(nlogn)。

空间复杂度 o(1) 空间取决于排序实现，如果使用 heapsort，通常需要 O(1)O(1) 辅助空间
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();
        Arrays.sort(s_chars);
        Arrays.sort(t_chars);
        
        return Arrays.equals(s_chars, t_chars);
    }
}