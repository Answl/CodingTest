import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<prices.length; i++){
            
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int i = stack.pop();
            answer[i] = prices.length-1 - i;
        }
        
        return answer;
    }
}

/**
1
2
3 -> 나가
(2)
3
**/