import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                 if(computers[i][j] == 1) list.get(i).add(j);
            }
        }
        //System.out.println(list);
        
        //bfs
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            //System.out.println(Arrays.toString(visited));
            if(!visited[i]) {
                queue.offer(i);
                visited[i] = true;
                answer ++;
                //System.out.println(i);
            while(!queue.isEmpty()){
            int cur = queue.poll();
            //System.out.println(cur + "" + list.get(cur));
            for(int l : list.get(cur)){
                //System.out.println(l + " "+ queue);
                if(visited[l]) continue;
                //System.out.println("넣자");
                queue.offer(l);
                visited[l] = true;
            }
            }
        }
        }
        
        return answer;
    }
}