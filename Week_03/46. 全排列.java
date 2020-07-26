
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList();
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backTrack(n, output,res,0);
        return res;
    }
    public void backTrack(int n, ArrayList<Integer> output, List<List<Integer>> res, int first) {
        
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }

        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backTrack(n,output,res,first+1);
            Collections.swap(output, first, i);
        }
    }
}



class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }
    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if(used[i]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len, depth + 1, path,used,res);
            path.removeLast();
            used[i]=false;
        }
    }

}