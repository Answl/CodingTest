// n개는 출입구, 쉼터, 정상 중 하나
// 양방향 통행 가능
// intensity : 선분의 길이 중 가장 긴거

// 등산코스에서 같은 출입구는 처음과 끝에 한 번씩만, 산봉우리는 한 번만 포함 && intensity가 최소가 되도록
// return [되는 것 중 (젤 작은) 산봉우리의 번호, intensity의 최솟값]
import java.util.*;
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<int[]>> graph = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] path : paths){
            graph.get(path[0]).add(new int[]{path[1], path[2]});
            graph.get(path[1]).add(new int[]{path[0], path[2]});
        }
        
        Set<Integer> summitSet = new HashSet<>();
        for(int summit : summits) summitSet.add(summit);
        
        
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
    
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int gate : gates){
            dist[gate] = 0;
            queue.offer(new int[]{gate, 0});
        }
            
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int node = cur[0], time = cur[1];
            
            if(dist[node] < time) continue;
            if(summitSet.contains(node)) continue;
            
            for(int[] g : graph.get(node)){
                int next = g[0], weight = g[1];
                
                int max = Math.max(time, weight);
                if(dist[next] > max){
                    dist[next] = max;
                    queue.offer(new int[]{next, dist[next]});
                }
            }
        }
        //System.out.println(Arrays.toString(dist));
        int min = Integer.MAX_VALUE, idx = 0;
        for(int i=1; i<=n; i++){
            if(summitSet.contains(i) && min > dist[i]){
                min = dist[i];
                idx = i;
            }
        }
        return new int[]{idx, min};
    }
}