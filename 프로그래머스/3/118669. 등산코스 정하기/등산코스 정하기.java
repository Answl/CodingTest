import java.util.*;
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Set<Integer> summitSet = new HashSet<>();
        for(int summit : summits) summitSet.add(summit);
        
        List<List<int[]>> gateList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            gateList.add(new ArrayList<>());
        }
        for(int[] path : paths){
            gateList.get(path[0]).add(new int[]{path[1], path[2]});
            gateList.get(path[1]).add(new int[]{path[0], path[2]});
        }
        
        Queue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int gate : gates){
            dist[gate] = 0;
            q.offer(new int[]{gate, 0});
        }
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int node = cur[0], time = cur[1];
            if(time > dist[node]) continue;
            if(summitSet.contains(node)) continue;
            
            for(int[] graph : gateList.get(node)){
                int next = graph[0], weight = graph[1];
                //System.out.println(next);
                if(dist[next] > Math.max(time, weight)){
                    dist[next] = Math.max(time, weight);
                    q.offer(new int[]{next, dist[next]});
                }
            }
        }
        //System.out.println(Arrays.toString(dist));
        int min = Integer.MAX_VALUE, idx = 0;
        for(int i = 1; i<=n; i++ ){
            if(summitSet.contains(i) && min > dist[i]){
                min = dist[i];
                idx = i;
            }
        }
        return new int[]{idx, min};
    }
}