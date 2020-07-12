爬楼梯

找重复子问题

1 ： 1阶
2 ： 1阶 ， 2阶
3 : 1阶*3 ， 1阶+2阶 ， 2阶+1阶

f3 = f3-1 + f3-2

class Solution {
    int[] m;
    public int climbStairs(int n) {
        m = new int[n+1];
        return ceil(n);
    }
    public int ceil(int n) {
        if (m[n] > 0) {
            return m[n];
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        m[n] = ceil(n-1) + ceil(n-2);
        return m[n];
    }

}


class Solution {
    public int climbStairs(int n) {
        int a=0;
        int b=1;
        int r=0;
        for (int i=0;i<n;i++) {
            r = a + b;
            a = b;
            b = r;
            
        }
        return r;
    }
    

}