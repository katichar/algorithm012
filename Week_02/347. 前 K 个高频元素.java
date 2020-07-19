
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> maxheap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        int[] result = new int[k];
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            maxheap.offer(m);
        }
        for(int i = 0; i < k; i++){
            result[i] = maxheap.poll().getKey();
        }

        return result;
    }
}


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num,map.get(num) + 1);
            }else{
                map.put(num,1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            new Comparator<Integer>(){
                @Override
                public int compare(Integer a, Integer b) {
                    return map.get(a) - map.get(b);
                }
            }
        );
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if(map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        int[] res = new int[k];
        int index = k-1;
        while (!pq.isEmpty()) {
            res[index--] = pq.remove();
        }
        return res;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
               map.put(num, map.get(num) + 1);
             } else {
                map.put(num, 1);
             }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        int[] res = new int[k];
        while (!pq.isEmpty()) {
            res[--k] = pq.remove();
            
        }
        return res;
    }
}