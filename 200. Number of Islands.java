class Solution {
    int count = 0;
    public int numIslands(char[][] grid) {
        if (grid.length==0) return count;
        int nr = grid.length; // rows of the matrix
        int nc = grid[0].length;  // columns of the matrix
        
        for (int i=0; i<nr; ++i){
            for(int j=0; j<nc; ++j){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c){
        // if exceeds the boundary of grid, then return;
        if (r<0 || c<0 || r>= grid.length|| c>= grid[0].length){
            return;
        }
        // return if it's vistied element
        if (grid[r][c]!='1') return;
        
        grid[r][c] = '2';  // mark the visted elements
        dfs(grid, r-1, c); // up
        dfs(grid, r+1, c); // down
        dfs(grid, r, c+1); // right
        dfs(grid, r, c-1); // left
    }
}