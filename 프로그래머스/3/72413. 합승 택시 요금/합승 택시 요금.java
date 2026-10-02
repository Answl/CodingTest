import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int[] f : fares){
            list.get(f[0]).add(new int[]{f[1], f[2]});
            list.get(f[1]).add(new int[]{f[0], f[2]});
        }
        
        int[] dp1 = dij(s, n, list);
        int[] dp2 = dij(a, n, list);
        int[] dp3 = dij(b, n, list);
//         System.out.println(Arrays.toString(dp1));
//         System.out.println(Arrays.toString(dp2));
//         System.out.println(Arrays.toString(dp3));
        
        for(int i=1; i<=n; i++){
            answer = Math.min(answer, dp1[i] + dp2[i] + dp3[i]);
        }
        
        return answer;
    }
    private int[] dij(int i, int n, List<List<int[]>> list){
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{i, 0}); dp[i] = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(dp[cur[0]] < cur[1]) continue;
            
            for(int[] l : list.get(cur[0])){
                if(dp[l[0]] > dp[cur[0]] + l[1]){
                    dp[l[0]] = dp[cur[0]] + l[1];
                    pq.offer(new int[]{l[0], dp[l[0]]});
                }
            }
        }
        return dp;
    }
}
