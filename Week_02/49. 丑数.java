最小堆解决
时间复杂度 o(n)
class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNums = {2,3,5};
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);
        int count = 0;
        while (!heap.isEmpty()) {
            long curr = heap.poll();
            if (++count >= n) return (int)curr;
            for (int num : uglyNums) {
                if (!heap.contains(num*curr)) heap.add(num*curr);
            }
            
            
        }
        return -1;
    }
}