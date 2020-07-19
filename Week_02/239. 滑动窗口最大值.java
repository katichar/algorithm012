

public int[] maxSlidingWindow(int[] nums, int k) {
    int[] ans = new int[nums.length - k + 1];
    int maxIndex = -1;
    int j = 0;
    for (int i = 0; i <= nums.length -k; i++) {
        if(i <= maxIndex && maxIndex < i + k) {
            if(nums[maxIndex] <= nums[i+k-1]) {
                maxIndex = i + k -1;
            }
        }else{
            maxIndex = i;
            for(int m = i; m <= i + k -1; m++) {
                if(nums[maxIndex] < nums[m]) maxIndex = m;
            }
        }
        ans[j++] = nums[maxIndex];
    }
    return ans;
}