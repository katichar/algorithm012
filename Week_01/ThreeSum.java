
// a + b = -c

三层循环

O(n^3)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();
        int s = 0;
        for (int i = 0; i < nums.length-2; ++i) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i+1, m = nums.length-1; j<m;) {
                s = nums[i] + nums[j] + nums[m];
                if (s == 0) {
                    List<Integer> value = Arrays.asList(nums[i] , nums[j] , nums[m]);
                    result.add(value);
                    while (j<m && nums[j] == nums[j+1]) j++;
                    while (j<m && nums[m] == nums[m-1]) m--;
                    --m;
                    ++j;
                }else{
                    if (s < 0 ) {
                        ++j;
                    }else{
                        --m;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}

时间复杂度 O(n^2)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if(nums[i]>0) break;
            if(i>0 && nums[i] == nums[i-1]) continue;
            int L=i+1;
            int R=len-1;
            while (L<R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while(L<R && nums[L]==nums[L+1]) L++;
                    while(L<R && nums[R]==nums[R-1]) R--;
                    L++;
                    R--;
                }else{
                    if(sum<0) L++;
                    else if(sum>0) R--;
                }
            }
        }
        return result;
    }
}