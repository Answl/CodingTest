class Solution {
    static int size;
    public int solution(int[] info, int[][] edges) {
        size = info.length;
        boolean[] visited = new boolean[size];
        visited[0] = true;
        return dfs(info, edges, visited, 0, 1, 0); //노드, 양
    }
    private int dfs(int[] info, int[][] edges, boolean[] visited, int node, int sheep, int wolf){
        if(sheep <= wolf) return sheep;
        int maxSheep = sheep;
        for(int[] edge : edges){
            int parent = edge[0], child = edge[1];
            if(visited[parent] && !visited[child]){
                visited[child] = true;
                //양
                if(info[child]==0){
                    maxSheep = Math.max(maxSheep, dfs(info, edges, visited, child, sheep+1, wolf));
                }else{
                    maxSheep = Math.max(maxSheep, dfs(info, edges, visited, child, sheep, wolf+1));
                }
                visited[child] = false;
            }
        }
        return maxSheep;
    }
}