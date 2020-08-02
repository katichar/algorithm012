class Solution {
    private int rows = 0;
    private int cols = 0;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        rows = grid.length;
        cols = grid[0].length;
        int nums = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    ++nums;
                    //dfs(grid,r,c);
                    bfs(grid,r,c);
                }
            }
        }
        return nums;
    }

    public void bfs(char[][] grid,int r,int c) {
        grid[r][c] = '0';
        Queue<Integer> neighbors = new LinkedList<>();
        neighbors.add(r*cols+c);
        while(!neighbors.isEmpty()){
            int id = neighbors.remove();
            int row = id / cols;
            int col = id % cols;
            if (row - 1 >= 0 && grid[row-1][col] == '1') {
                neighbors.add((row-1)*cols + col);
                grid[row-1][col]='0';
            }
            if (row + 1 < rows && grid[row+1][col] == '1') {
                neighbors.add((row+1)*cols + col);
                grid[row+1][col]='0';
            }

            if (col - 1 >= 0 && grid[row][col-1] == '1') {
                neighbors.add(row*cols + col -1);
                grid[row][col-1]='0';
            }

            if (col + 1 < cols && grid[row][col+1] == '1') {
                neighbors.add(row*cols + col +1);
                grid[row][col+1]='0';
            }
        }
    }

    public void dfs(char[][] grid,int r,int c) {
        if (r<0 || r>=rows || c<0 || c>=cols || grid[r][c] == '0') return;
        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
}