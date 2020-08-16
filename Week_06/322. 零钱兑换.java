
bfs
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        Arrays.sort(coins);
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(amount);
        boolean[] visted = new boolean[amount+1];
        visted[amount]=true;
        int step = 1;
        while(!nodes.isEmpty()){
            int size = nodes.size();
            for(int i = 0; i < size; i++){
                int head = nodes.poll();
                for(int coin : coins){
                    int next = head - coin;
                    if(next == 0) return step;
                    if(next < 0) break;
                    if(!visted[next]){
                        nodes.add(next);
                        visted[next]=true;
                    }
                    
                }
            }
            step++;
        }
        return -1;
    }
}
动态规划
class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[max];
        Arrays.fill(dp,max);
        dp[0]=0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}