import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        for(int[] wire : wires){
            //제거할 엣지 빼고 graph 만들기
            List<List<Integer>> graph = makeGraph(wire[0], wire[1], wires, n);
            
            //위 graph를 가지고 bfs 돌리기
            int diff = Math.abs(n - 2 * bfs(graph, n));
            min = Math.min(diff, min);
        }
        return min;
    }
    
    private int bfs(List<List<Integer>> graph, int n){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        
        int curCnt = 0;
        q.offer(1);
        visited[1] = true;
        
        while(!q.isEmpty()){
            int curNode = q.poll(); 
            curCnt ++;
            
            for(Integer node : graph.get(curNode)){
                if(!visited[node]){
                    q.offer(node);
                    visited[node] = true;
                }
            }
        }
        return curCnt;
    }
    
    private List<List<Integer>> makeGraph(int a, int b, int[][] wires, int n){
        List<List<Integer>> graph = new ArrayList<>();
        
        //초기화
        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] wire : wires){
            if(wire[0] == a && wire[1] == b) continue;
            else{
                graph.get(wire[0]).add(wire[1]);
                graph.get(wire[1]).add(wire[0]);
            }
        }
        return graph;
    }
}