// dfs
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

// unionFind
class Solution {
    int[] parent;
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        parent = new int[cities];
        int provinces = 0;
        for (int i =0; i<cities; i++){
            parent[i]=i;
        }
        for(int i = 0; i<cities; i++){
            for (int j = 0; j<cities; j++){
                if (isConnected[i][j]==1){
                    union(i, j);
                }
            }
        }
        for (int i = 0; i<cities; i++){
            if (parent[i] == i){
                provinces++;
            }
        }
    return provinces;
    }

    public void union(int i, int j){
        parent[find(i)] = find(j); // let i's root becomes child of j's root
    }

    public int find(int i){ // find the root of i 
        if (parent[i] != i){
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
}