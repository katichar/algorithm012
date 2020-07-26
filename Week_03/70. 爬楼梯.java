
解题：递归
时间复杂 o(n)
空间复杂度 o(n)
class Solution {
    private int[] temp;
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        temp = new int[n];
        return general(n);
    }
    public int general(int n){
        if (n == 1) {
            return 1;
        }else if(n == 2) {
            return 2;
        }else{
            if (temp[n-1]>0) return temp[n-1];
            temp[n-1]=general(n-1) + general(n-2);
            return temp[n-1];
        }
    }
}