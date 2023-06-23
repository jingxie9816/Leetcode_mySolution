class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        for (int i = 0; i<cities; i++){
            if(!visited[i]){
                dfs(i,cities,isConnected,visited);
                provinces++;
            }
            
        }
        return provinces;
    }

    public void dfs(int city_index, int cities, int[][] isConnected, boolean[]visited){
        for(int j=0; j<cities; j++) {
            if(isConnected[city_index][j]==1 && !visited[j]){
                visited[j] = true;
                dfs(j,cities,isConnected,visited);
            }
        }
    }
}