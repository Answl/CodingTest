class Solution {
    
    public int solution(int[] info, int[][] edges) {
        int node = info.length;
        boolean[] visited = new boolean[node];
        visited[0] = true;
        return dfs(info, edges, visited, 1, 0); //sheep, wolf
    }
    private int dfs(int[] info, int[][] edges, boolean[] visited, int sheep, int wolf){
        if(sheep <= wolf) return sheep;
        int maxSheep = sheep;
        
        for(int[] edge : edges){    
            int parent = edge[0], child = edge[1];
            if(visited[parent] && !visited[child]){
                visited[child] = true;
                // 양
                if(info[child] == 0){
                    maxSheep = Math.max(maxSheep, dfs(info, edges, visited, sheep+1, wolf));
                }
                //늑대
                else{
                    maxSheep = Math.max(maxSheep, dfs(info, edges, visited, sheep, wolf+1));
                }
                visited[child] = false;
            }
        }
        return maxSheep;
    }
}