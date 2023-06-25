//dfs
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid==null || grid.length==0) return 0;
        int ret=0;
        int nr = grid.length;
        int nc = grid[0].length;
        for (int i=0; i< nr; i++){
            for (int j=0; j<nc; j++){
                if(grid[i][j]==1){
                    ret = Math.max(ret, dfs(grid, i, j));
                }
            }
        }
        
        return ret;
    }

    public int dfs(int[][] grid, int r, int c){
        if (r<0 || c<0 || r>= grid.length|| c>= grid[0].length){
            return 0;
        }
        if (grid[r][c] != 1) return 0;
        
        grid[r][c] = 2;

        return 1 
              + dfs(grid, r+1, c) 
              + dfs(grid, r-1, c)
              + dfs(grid, r, c+1)
              + dfs(grid, r, c-1);
    }
}


//bfs_queue
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid==null || grid.length ==0) return 0;
        Queue<Integer> queue_i = new LinkedList<>();
        Queue<Integer> queue_j = new LinkedList<>();  // queue only accept one argument
        int nr = grid.length;
        int nc = grid[0].length;
        int ret = 0;
        for(int i=0; i<nr; i++){
            for (int j=0; j<nc; j++){
                if(grid[i][j]==1){
                    queue_i.offer(i);
                    queue_j.offer(j);
                    int curr = 0;
                    while(!queue_i.isEmpty() && !queue_j.isEmpty()){
                        int r = queue_i.poll();
                        int c = queue_j.poll();
                        if (r<0 || c<0 || r>=nr || c>= nc || grid[r][c]!=1){
                            continue;
                        }
                        curr++;
                        grid[r][c] = 2;

                        queue_i.offer(r-1); queue_j.offer(c);
                        queue_i.offer(r); queue_j.offer(c-1);
                        queue_i.offer(r+1); queue_j.offer(c);
                        queue_i.offer(r); queue_j.offer(c+1);
                    }
                    ret = Math.max(ret, curr);
                }    
            }
        }
        return ret;
    }
}