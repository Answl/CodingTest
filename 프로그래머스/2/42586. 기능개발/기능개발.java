import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++){
            progresses[i] = 100 - progresses[i];
            progresses[i] = (int) Math.ceil((double) progresses[i] / speeds[i]);
            
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            
            if(progresses[stack.peek()] < progresses[i]) {
                list.add(i-stack.pop());
                stack.push(i);
            }
        }
    
        list.add(progresses.length - stack.pop());
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}