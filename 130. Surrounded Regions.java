//DFS
class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length==0) return;
        int nr = board.length;
        int nc = board[0].length;
        //start from the 'O' on boarder
        for (int i=0; i<nr; i++){
            dfs(board, i, 0);
            dfs(board, i, nc-1);
        }
        for (int j=0; j<nc; j++){
            dfs(board, 0, j);
            dfs(board, nr-1, j);
        }
        for (int i=0; i<nr; i++){
            for (int j=0; j<nc; j++){
                if(board[i][j]=='O'){
                    board[i][j]='X'; //surrounded O change to X
                }
                if(board[i][j]=='Y'){
                    board[i][j]='O'; //return back to '0'
                }
            }
        }
    }

    public void dfs(char[][] board, int r, int c){
        if(r<0 || c<0 || r==board.length || c==board[0].length){
            return;
        }
        if(board[r][c] != 'O') return;
        board[r][c] = 'Y'; // change O to Y, for all O that is directly or indirectly connected to boarder
        dfs(board, r+1, c);
        dfs(board, r, c+1);
        dfs(board, r-1, c);
        dfs(board, r, c-1);
    }

}

//BFS
class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length==0) return;
        int nr = board.length;
        int nc = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        //start from the 'O' on boarder
        for (int i=0; i<nr; i++){
            if(board[i][0]=='O'){
                queue.offer(new int[]{i, 0});
                board[i][0]='Y';
            }
            if(board[i][nc-1]=='O'){
                queue.offer(new int[]{i, nc-1});
                board[i][nc-1]='Y';
            }
        }
        for (int j=0; j<nc; j++){
            if(board[0][j]=='O'){
                queue.offer(new int[]{0, j});
                board[0][j]='Y';
            }
            if(board[nr-1][j]=='O'){
                queue.offer(new int[]{nr-1, j});
                board[nr-1][j]='Y';
            }
        }
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        while(!queue.isEmpty()){
            int[] axis = queue.poll();
            int r = axis[0];
            int c = axis[1];
            for (int i=0; i<4; i++){
                int m = r + dx[i];
                int n = c + dy[i];
                if (m<0 || n<0 || m>= nr || n>= nc || board[m][n] != 'O'){
                    continue;
                }
                queue.offer(new int[]{m, n});
                board[m][n]='Y';
            }
        }

        for (int i=0; i<nr; i++){
            for (int j=0; j<nc; j++){
                if(board[i][j]=='Y'){
                    board[i][j]='O'; //return back to '0'
                } else if(board[i][j]=='O'){
                    board[i][j]='X'; //surrounded O change to X
                }
            }
        }
    }
}