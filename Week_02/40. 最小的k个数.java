

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }
}


class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0) {
            return new int[0];
        }
        // 小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll(); //每次取最小值，并删掉最小值
        }
        
        return ans;
    }
}

public int[] getLeastNumbers(int[] arr, int k) {
    if(k == 0) {
        return new int[0];
    }
    Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
    for(int i: arr) {
        if(queue.size() < k) {
            queue.add(i);
        } else {
            if(queue.peek() > i) {
                queue.remove();
                queue.add(i);
            }
        }
    }
    int[] ref = new int[k];
    int cnt = 0;
    while(queue.size() > 0) {
        ref[cnt++] = queue.remove();
    }
    return ref;
}

// 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
// 1. 若目前堆的大小小于K，将当前数字放入堆中。
// 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
//    反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1,v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            }else if(num < pq.peek()){
                pq.poll();
                pq.offer(num);
            }
        }
        int[] res = new int[pq.size()];
        int index = 0;
        for (int num : pq) {
            res[index++] = num;
        }
        return res;
    }
}
