时间复杂度 o(n)
空间复杂度 o(n)
思路：用map替代嵌套循环 containsKey
public int[] twoSum(int[] nums, int target) {
    int[] ans = new int[2];
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(target - nums[i])) {
            ans[1] = i;
            ans[0] = map.get(target - nums[i]);
            return ans;
        }
        map.put(nums[i],i);
    }
    return  ans;
}