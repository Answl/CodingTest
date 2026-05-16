import java.util.*;

class Solution {
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        List<int[]> list = new ArrayList<>();
        
        for(int i=0; i<plans.length; i++){
            int s = Integer.parseInt(plans[i][1].split(":")[0]) * 60 + 
                Integer.parseInt(plans[i][1].split(":")[1]);
            list.add(new int[]{i, s, Integer.parseInt(plans[i][2])});
        }
        
        Collections.sort(list, (a,b) -> a[1]-b[1]);
        
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        
        int idx=0;
        for(int i=0; i<plans.length-1; i++){
            int[] now = list.get(i);
            int[] next = list.get(i+1);
            
            int gap = next[1] - now[1];
            if(gap >= now[2]){ // 실행
                answer[idx++] = plans[now[0]][0];
                
                int rest = gap - now[2];
                while(rest > 0 && !stack.isEmpty()){
                    int[] paused = stack.pollLast();
                    
                    if(paused[1] <= rest){ //꺼내서 다 실행
                        rest -= paused[1];
                        answer[idx++] = plans[paused[0]][0];
                    } else { //안되면 다시 넣어
                        paused[1] -= rest;
                        stack.add(paused);
                        rest = 0;
                    }
                }
            }
            else {
                stack.add(new int[]{now[0], now[2] - gap});
            }
        }
        answer[idx++] = plans[list.get(plans.length-1)[0]][0];
        
        while(!stack.isEmpty()){
            int[] paused = stack.pollLast();
            answer[idx++] = plans[paused[0]][0];
        }
        
        return answer;
    }
}