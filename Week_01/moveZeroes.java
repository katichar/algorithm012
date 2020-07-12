时间复杂度： O(n)
空间复杂度: O(1)
思路:遍历数组，遇到非0移动到前面，用变量j记录顺序下标

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}

缺点：如果前面有多个非0，属于不必要的移动操作
思路：记录为0最小下标，当需要非0时，与之交换
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > j ){
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j++] = tmp;
                }else{
                    j++;
                }
                
            }
        }
    }
}

时间复杂度: O(n)
空间复杂度：O(1)
思路：把非0数赋值到最左边，变量j记录最大非0下标，再把大于j下标的数组元素赋值0
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}

缺点：执行了两次循环，
时间复杂度O(n)
空间复杂度O(1)
思路：把移动到最左边的当前数组值置为0，就不必要第二循环了
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {

                nums[j] = nums[i];
                if (j != i) {
                    nums[i] = 0;
                }
                j++;
            }
            
        }
    }
}

改进上面：不处理相对顺序正常的非0项
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > j) {
                    nums[j++] = nums[i];
                    nums[i] = 0;
                }else{
                    j++;
                }
                
                
            }
            
        }
    }
}